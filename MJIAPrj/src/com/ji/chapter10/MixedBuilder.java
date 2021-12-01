package com.ji.chapter10;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class MixedBuilder {

	public static Order forCustomer(String customer, TradeBuilder... builders) {
		Order order = new Order();
		order.setCustomer(customer);
		Stream.of(builders).forEach(b -> order.addTrade(b.trade));
		return order;
	}

	public static TradeBuilder buy(Consumer<TradeBuilder> consumer) {
		return buildTrade(consumer, Trade.Type.BUY);
	}

	public static TradeBuilder sell(Consumer<TradeBuilder> consumer) {
		return buildTrade(consumer, Trade.Type.SELL);
	}

	private static TradeBuilder buildTrade(Consumer<TradeBuilder> consumer, Trade.Type buy) {
		TradeBuilder builder = new TradeBuilder();
		builder.trade.setType(buy);
		consumer.accept(builder);
		return builder;
	}

}
