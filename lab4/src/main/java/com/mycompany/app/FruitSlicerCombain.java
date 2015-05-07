package com.mycompany.app;

import java.util.Map;

public class FruitSlicerCombain extends FruitSlicer{

	private Map<String, IFruit> sliceConveyor;
	
	@SuppressWarnings("unchecked")
	public FruitSlicerCombain(){
		super();
		sliceConveyor = (Map<String, IFruit>) StaticInfo.SERVICE_CONTEXT.getBean("initCWP");
	}
	
	@SuppressWarnings("unchecked")
	public FruitSlicerCombain(IFruit k){
		super(k);
		sliceConveyor = (Map<String, IFruit>) StaticInfo.SERVICE_CONTEXT.getBean("initCWP");
	}
	
	public FruitSlicerCombain(Map<String, IFruit> conv){
		super();
		setSliceConveyor(conv);
	}
	
	public void multySlice() {
		System.out.println(">> Preparing fruit salad : ");
		for(String s: sliceConveyor.keySet()){
			System.out.println(">>> Slicing "+sliceConveyor.get(s).getName());
		}
		System.out.println(">> Ready!!!");
	}

	public Map<String, IFruit> getSliceConveyor() {
		return sliceConveyor;
	}

	public void setSliceConveyor(Map<String, IFruit> sliceConveyor) {
		this.sliceConveyor = sliceConveyor;
	}
}
