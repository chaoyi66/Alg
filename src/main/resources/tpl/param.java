package com.cc.xt.market.common.param;

import com.cc.xt.market.common.VO.%su;
import com.jiji.xmen.cable.commons.base.BaseObject;
import com.jiji.xmen.cable.commons.utils.BeanUtils;

public class %suParam extends BaseObject {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public %su convert2VO() {
		%su vo = BeanUtils.convert(this, %su.class);
		return vo;
	}
}
