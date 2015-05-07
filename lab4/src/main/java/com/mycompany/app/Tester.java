package com.mycompany.app;


public class Tester {

	public static void main(String[] args) {

		
		// Testing Fruits
		IFruit fruit = StaticInfo.CONTEXT.getBean("unknfr", IFruit.class);
		System.out.println(fruit.getName());
		IFruit apple = StaticInfo.CONTEXT.getBean("apple", IFruit.class);
		System.out.println(apple.getName());
		IFruit orange = StaticInfo.CONTEXT.getBean("orange", IFruit.class);
		System.out.println(orange.getName());
		IFruit melon = StaticInfo.CONTEXT.getBean("melon", IFruit.class);
		System.out.println(melon.getName());
		
		// Testing FruitSlicer
		{
			System.out.println("\n> Test instance of FruitSlicer created with a constructor by default");
			ISlicer fruitSlicer = StaticInfo.CONTEXT
					.getBean("frSlNoArgs", FruitSlicer.class);
			fruitSlicer.slice();
			fruitSlicer.multySlice();
		}
		{
			System.out.println("\n> Test instance of FruitSlicer created with a constructor with parameter");
			ISlicer fruitSlicer = StaticInfo.CONTEXT
					.getBean("frSlArg", FruitSlicer.class);
			fruitSlicer.slice();
			fruitSlicer.multySlice();
		}
		{
			System.out.println("\n> Test instance of FruitSlicer created with a constructor by default and properties");
			ISlicer fruitSlicer = StaticInfo.CONTEXT
					.getBean("frSlProp", FruitSlicer.class);
			fruitSlicer.slice();
			fruitSlicer.multySlice();
		}
		
		// Testing FruitSlicerCombain
		{
			System.out.println("\n> Test instance of FruitSlicerCombain created with a constructor by default");
			ISlicer fruitSlicer = StaticInfo.CONTEXT
					.getBean("frSlComNoArgs", FruitSlicer.class);
			fruitSlicer.slice();
			fruitSlicer.multySlice();
		}
		{
			System.out.println("\n> Test instance of FruitSlicerCombain created with a constructor with IFruit parameter");
			ISlicer fruitSlicer = (FruitSlicer) StaticInfo.CONTEXT
					.getBean("frSlComFruitArgs");
			fruitSlicer.slice();
			fruitSlicer.multySlice();
		}
		{
			System.out.println("\n> Test instance of FruitSlicerCombain created with a constructor with Map<String, IFruit> parameter");
			ISlicer fruitSlicer = (FruitSlicer) StaticInfo.CONTEXT
					.getBean("frSlComMapArgs");
			fruitSlicer.slice();
			fruitSlicer.multySlice();
		}
		{
			System.out.println("\n> Test instance of FruitSlicerCombain created with a constructor by default and properties");
			ISlicer fruitSlicer = (FruitSlicer) StaticInfo.CONTEXT
					.getBean("frSlComProp");
			fruitSlicer.slice();
			fruitSlicer.multySlice();
		}
	}

}
