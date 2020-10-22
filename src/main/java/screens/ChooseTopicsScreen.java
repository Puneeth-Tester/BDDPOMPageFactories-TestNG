package screens;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChooseTopicsScreen extends ScreenBase {
	
	@AndroidFindBy(id="flipboard.app:id/topic_picker_topic_row_topic_tag")
	public List<AndroidElement> topic;
	
	
	@AndroidFindBy(id="flipboard.app:id/topic_picker_continue_button")
	public WebElement pickerContinueButton;
	
	@AndroidFindBy(id="flipboard.app:id/account_login_buttons_skip")
	public WebElement skipButton;

	@AndroidFindBy(id="flipboard.app:id/flipboard_tv_pitch_not_now_button")
	public WebElement skipIWillWatchAds;
	
	public ChooseTopicsScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public ChooseTopicsScreen chooseTopics(int topicsCount) {
		
		for(int i=0; i<topicsCount; i++) {
			topic.get(i).click();
		}
		
		return this;
	}
	
	
	
	public ChooseTopicsScreen clickContinue() {
		pickerContinueButton.click();
		return this;
	}
	
	public HomeScreen skipLogin() {
		skipButton.click();
		try {
			Thread.sleep(3000L);
		}catch(Exception e) {
			
		}
		skipIWillWatchAds.click();
		try {
			Thread.sleep(3000L);
		}catch(Exception e) {
			
		}
		back();
		return new HomeScreen(driver);
	}
	

}
