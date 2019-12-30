package com.game.constant;

public enum RulesEnum {
	Trail(4), Sequence(3), Pair(2), TopCard(1), None(0);

	private final int rule;

	private RulesEnum(int rule) {
		this.rule = rule;
	}

	public int getRule() {
		return rule;
	}
}
