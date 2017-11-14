package com.cc.xt.market.web.controller;


import com.cc.xt.market.common.VO.%su;
import com.cc.xt.market.common.base.Add;
import com.cc.xt.market.common.base.Update;
import com.cc.xt.market.common.model.%suModel;
import com.cc.xt.market.common.param.%suPageParam;
import com.cc.xt.market.common.param.%suParam;
import com.cc.xt.market.common.response.Response;
import com.cc.xt.market.service.intf.%suService;
import com.cc.xt.market.web.base.BaseController;
import com.cc.xt.market.web.base.ParamValidateUtils;
import com.jiji.xmen.cable.commons.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("%ss")
public class %suController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(%suController.class);

	@Autowired
	private %suService %ssService;

	@RequestMapping(method = RequestMethod.POST, value = "add")
	public Response save(HttpServletRequest request, HttpServletResponse response,
	                     @RequestBody @Validated({Add.class}) %su param, BindingResult result) {

		if (result.hasErrors()) {
			throw new IllegalArgumentException(ParamValidateUtils.getErrorMessages(result));
		}
		Long id = %ssService.add(param);
		return new Response(id);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "update")
	public Response update(HttpServletRequest request, HttpServletResponse response,
	                       @RequestBody @Validated({Update.class}) %su param, BindingResult result) {

		if (result.hasErrors()) {
			throw new IllegalArgumentException(ParamValidateUtils.getErrorMessages(result));
		}
		%ssService.updateById(param);
		return new Response();
	}

	@RequestMapping(method = RequestMethod.POST, value = "save")
	public Response save(HttpServletRequest request, HttpServletResponse response,
	                     @RequestBody %suParam param, BindingResult result) {

		if (result.hasErrors()) {
			throw new IllegalArgumentException(ParamValidateUtils.getErrorMessages(result));
		}
		%su %ss = param.convert2VO();
		if (param.getId() == null)
			%ssService.add(%ss);
		else
			%ssService.updateById(%ss);
		return new Response();
	}


	@RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
	public Response delete(HttpServletRequest request, HttpServletResponse response, @PathVariable Long id) {

		%ssService.deleteById(id);
		return new Response();
	}


	@RequestMapping(method = RequestMethod.GET, value = "select/{id}")
	public Response select(HttpServletRequest request, HttpServletResponse response, @PathVariable Long id) {

		%su rs = %ssService.selectById(id);
		return new Response(rs);
	}

	@RequestMapping(method = RequestMethod.POST, value = "selectList")
	public Response selectList(HttpServletRequest request, HttpServletResponse response, @RequestBody %su param) {

		List<%su> list = %ssService.selectListByEO(param);
		return new Response(list);
	}

	@RequestMapping(method = RequestMethod.POST, value = "queryPage")
	public Response selectList(HttpServletRequest request, HttpServletResponse response, @RequestBody %suPageParam param) {

		Page<%suModel> page = %ssService.queryPage(param);
		return new Response(page);
	}

}
