package com.sample.test.demo.tests;

import com.sample.test.demo.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertSame;

public class HappyPathTest extends TestBase {


    @Test
    public void placeOrder(){
        //Select The First Type of Pizza
        WebElement pizzaType = driver.findElement(By.id("pizza1Pizza"));
        List<WebElement> pizzas = pizzaType.findElements(By.tagName("option"));
        pizzaType.click();
        pizzas.get(1).click();

        //Input quantity of pizzas
        WebElement quantity = driver.findElement(By.id("pizza1Qty"));
        quantity.click();
        quantity.clear();
        quantity.sendKeys("1");
        quantity.sendKeys("\t");

        //Verify the pizza cost without toppings
        WebElement pizzaCost = driver.findElement(By.id("pizza1Cost"));
        String pizzaCostString = pizzaCost.getAttribute("value");
        assertTrue(pizzaCostString.equals("6.75"));

        //Input Pickup Info
        WebElement name = driver.findElement(By.id("name"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement phone = driver.findElement(By.id("phone"));

        name.sendKeys("Evan L. Allen");
        email.sendKeys("e.levi.allen@gmail.com");
        phone.sendKeys("267-370-8983");

        //select cash payment
        WebElement cash = driver.findElement(By.id("cashpayment"));
        cash.click();

        //Submit Order
        WebElement placeOrder = driver.findElement(By.id("placeOrder"));
        placeOrder.click();

        //Assert confirmation dialog
        WebElement dialogueBox = driver.findElement(By.id("dialog"));
        WebElement boxText = dialogueBox.findElement(By.tagName("p"));
        assert(boxText.isDisplayed());
    }


}
