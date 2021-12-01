package com.ji.chapter10;

public class TradeBuilder {
	private final MethodChainingOrderBuilder builder;
	public final Trade trade = new Trade();
	
	public TradeBuilder() {
		this.builder = null;
	}
	
	public TradeBuilder quantity(int quantity) {
		trade.setQuantity(quantity);
		return this;
	}

	public TradeBuilder(MethodChainingOrderBuilder builder, Trade.Type type, int quantity) {
		this.builder = builder;
		trade.setType(type);
		trade.setQuantity(quantity);	
	}
	
	public StockBuilder stock(String symbol) {
		return new StockBuilder(builder, trade, symbol);
	}
}
