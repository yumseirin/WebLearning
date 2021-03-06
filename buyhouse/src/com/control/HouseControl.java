package com.control;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.service.HouseServiceImpl;
import com.service.HouseServiceInf;
import com.service.UserServiceImpl;
import com.service.UserServiceInf;
import com.util.CommonConstant;
import com.vo.House;
import com.vo.Orderdetail;
import com.vo.Orders;

@Controller
@RequestMapping("houseControl")
public class HouseControl {
	private int page = 1;

	@RequestMapping("/saveHouse")
	public String saveHouse(House house, @RequestParam MultipartFile pic2) {

		HouseServiceInf service = new HouseServiceImpl();
		try {
			house.setPic(pic2.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		service.saveHouse(house);

		return "forward:/houseControl/paging.action";
	}

	@RequestMapping("/listHouse")
	public String listHouse(Model model, HttpSession session) {
		HouseServiceInf service = new HouseServiceImpl();
		List<House> list = service.listHouse();
		model.addAttribute("list", list);
		return "forward:/WEB-INF/main/main.jsp";
	}

	@ResponseBody
	@RequestMapping("/getHouseImg")
	public byte[] getHouseImg(int id) {
		HouseServiceInf service = new HouseServiceImpl();
		byte[] b = null;
		try {
			b = service.getHouseImg(id);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return b;
	}

	@RequestMapping("/getHouseImg2")
	public void getImg(int id, HttpServletResponse response) {

		HouseServiceInf service = new HouseServiceImpl();
		try {
			byte[] pic = service.getHouseImg(id);
			if (pic != null) {
				ServletOutputStream out = response.getOutputStream();
				out.write(pic);
				out.flush();
				out.close();
			}
		} catch (Exception e) {

		}

	}

	@RequestMapping("/order")
	public String order(Orders order, Orderdetail orderdetail,
			HttpSession session, HttpServletRequest request) {
		HouseServiceInf service = new HouseServiceImpl();
		UserServiceInf service2 = new UserServiceImpl();
		String uname = (String) session.getAttribute("uname");

		int userid = service2.getID(uname);
		Date date = new Date();
		String ordernum = date.toString();

		order.setOrdernum(ordernum);
		order.setUserid(userid);

		String houseid = request.getParameter("houseid");
		orderdetail.setOrdernum(ordernum);
		orderdetail.setHouseid(Integer.parseInt(houseid));

		service.order(order, orderdetail);
		service.setStatus(Integer.parseInt(houseid));

		return "forward:/houseControl/listHouse.action";
	}

	@RequestMapping("/paging")
	public String paging(Model model, HttpServletRequest request) {
		String index = request.getParameter("page");
		if (index != null) {
			page = Integer.parseInt(index);
		}
		// 取总条数
		HouseServiceInf service = new HouseServiceImpl();
		int zongtiao = service.getCountTiao();
		// 每页显示多少条
		int tiao = CommonConstant.PAGEROW;//每页显示几条记录

		// 页数 总页数=总条数%每页要显示的条数 ==0？总条数/每页要显示的条数 :总条数/每页要显示的条数 +1
		int yeshu = zongtiao % tiao == 0 ? zongtiao / tiao : zongtiao / tiao
				+ 1;

		// 判断
		if (page > yeshu) {
			page = yeshu;
		}
		if (page <= 0) {
			page = 1;
		}
		int start = (page - 1) * tiao + 1;
		int end = page * tiao;

		List<House> list = service.getHousePage(start, end);
		model.addAttribute("list", list);
		model.addAttribute("yeshu", yeshu);
		model.addAttribute("page", page);
		return "forward:/WEB-INF/main/main.jsp";
	}
}
