package com.maygard.core;


public class NewtonYield extends NewtonRaphson
{
	public NewtonYield(double initialval, double precision,
	int iterations ) {
		inputvalue=initialval;
		iteration=iterations;
		prec=precision;
	}
	
	protected double nominalstockprice;
	protected double termperiod;
	protected double couponrate;
	protected double marketpricevalue;
	protected double inputvalue;
	protected double rateperTerm;
	protected double maturityperiod;
	protected double rateindex;
	int iteration;
	double prec;
	
	public double newtonroot(double rootinput)
	//implements the abstract method from interval bisection
	{
		double poscashflow,solution;
		poscashflow=rateperTerm;//cashflow out per term as monthly
		//amount * termperiod//
		solution=(poscashflow/rootinput*(1.0-1.0/(Math.pow(1.0+rootinput,rateindex))))+(nominalstockprice/
		(Math.pow(1.0+rootinput, rateindex)))-marketpricevalue;
		return solution;
	}
	
	public double yield(double noms, double term, double coupon,
	double mktp, double period) {
		nominalstockprice=noms;
		termperiod=term;
		couponrate=coupon;
		marketpricevalue=mktp;
		rateperTerm=((coupon/term));
		maturityperiod=period;
		rateindex=(maturityperiod*term);
		accuracy(prec,iteration);
		return newtraph(inputvalue);
	}

}
