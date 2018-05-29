package com.cc.xt.market.service.intf;


import com.cc.xt.market.api.I%suService;
import com.cc.xt.market.common.model.%suModel;
import com.cc.xt.market.common.param.%suPageParam;
import com.jiji.xmen.cable.commons.pagination.Page;

public interface %suService extends I%suService {

	/**
	 * 分页查询接口
	 *
	 * @param param
	 * @return
	 */
	Page<%suModel> queryPage(%suPageParam param);
}
