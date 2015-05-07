package com.mycompany.app;

public class FruitSlicer implements ISlicer {

	private IFruit fruit;

	public FruitSlicer() {
		setFruit((IFruit) StaticInfo.SERVICE_CONTEXT.getBean("unknfr"));
	}

	public FruitSlicer(IFruit fruit) {
		if (fruit == null)
			setFruit((IFruit) StaticInfo.SERVICE_CONTEXT.getBean("unknfr"));
		else
			setFruit(fruit);
	}

	public void slice() {
		System.out.println(">> Slicing " + fruit.getName());
	}

	public void multySlice() {
		System.out.println(">> !!! This slicer does not support multy slicing !!!");
	}

	public IFruit getFruit() {
		return fruit;
	}

	public void setFruit(IFruit fruit) {
		this.fruit = fruit;
	}

}
