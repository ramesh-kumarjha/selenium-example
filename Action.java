
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Action extends Page {


    WebDriver driver;

    public Action(WebDriver driver) {
        super(driver);
    }

    public void filledSearchTextBox(String value) throws InterruptedException {
        Thread.sleep(5000);
        SearchTextBox.click();
        SearchTextBox.sendKeys(value);
        SearchTextBox.clear();
        Thread.sleep(3000);
        String inputValue = SearchTextBox.getText();
        Assert.assertTrue(value.contains(inputValue));
    }

    public void verifyAutosuggest(String value) throws InterruptedException {
        SearchTextBox.sendKeys(value);
        Thread.sleep(3000);
        for (WebElement element : AutosuggestValue) {
            String autoSuggestValue = element.getText();
            Assert.assertTrue(autoSuggestValue.contains(value));

        }
    }

    public void verfiyZeroResultQuery(String value) throws InterruptedException {
        Thread.sleep(5000);
        SearchTextBox.sendKeys(value);
        SearchTextBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        int size = pdpSecondListValue.size();
        Assert.assertTrue(size > 0);
    }

    public void verfiySortFilter() {
        SearchTextBox.sendKeys("shirt");
        SearchTextBox.sendKeys(Keys.ENTER);
        sortDropDown.click();
        priceLowtoHigh.click();
        String values = sortDropDown.getText();
        String value = priceLowtoHigh.getText();
        Assert.assertTrue(values.equals(value));


    }

    public void verfiyFirstpdp() {
        for (WebElement ele : PdpListone) {
            String value = ele.getText();
            ele.click();
            String pdpValue = pdpOneValue.getText();
            Assert.assertTrue(pdpValue.contains(value));
        }

    }

    public void verfiySecondPdp() throws InterruptedException {
        Thread.sleep(4000);
        hederValueGirl.click();
        Thread.sleep(3000);
        secondPdpvalue.click();
        int size = pdpSecondList.size();
        Assert.assertTrue(size > 0);

    }

    public void shortverfiyPrice() throws InterruptedException {
        SearchTextBox.sendKeys("shirt");
        SearchTextBox.sendKeys(Keys.ENTER);
        sortDropDown.click();
        priceLowtoHigh.click();
        Thread.sleep(4000);
        ArrayList<Float> list = new ArrayList<Float>();
        for (WebElement ele : priceList) {
            String value = ele.getText().replace("$", "");
            list.add(Float.valueOf(value));

        }
        ArrayList sortValue = new ArrayList(list);
        Collections.sort(sortValue);
        Assert.assertTrue(sortValue.equals(list));
    }


}






