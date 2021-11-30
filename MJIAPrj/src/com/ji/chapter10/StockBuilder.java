package com.ji.chapter10;

public class StockBuilder {
	private final MethodChainingOrderBuilder builder; 
	private final Trade trade; 
	private final Stock stock = new Stock();
	
	StockBuilder(MethodChainingOrderBuilder builder, Trade trade, String symbol) {
		this.builder = builder; 
		this.trade = trade;
		stock.setSymbol(symbol);
	}
	
	public TradeBuilderWithStock on(String market) {
		stock.setMarket(market);
		trade.setStock(stock);
		return new TradeBuilderWithStock(builder, trade);
	}

}
