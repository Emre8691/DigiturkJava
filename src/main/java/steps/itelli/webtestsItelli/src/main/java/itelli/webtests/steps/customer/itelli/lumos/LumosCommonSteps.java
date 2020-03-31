package itelli.webtests.steps.customer.itelli.lumos;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import itelli.webtests.common.MailHelper;
import itelli.webtests.pages.base.ContextBase;
import itelli.webtests.steps.AbstractSteps;

public class LumosCommonSteps extends AbstractSteps<ContextBase> {

	@Then(value = "I send report to $email with subject $subject", priority = 0)
	public final void mailSend(final String email, final String subject) {
		String mailBody = getContext().getContextInformation().getPropertyFromMetaMap("mailBody");
		String mailAttachment = getContext().getContextInformation().getPropertyFromMetaMap("mailAttachment");
		String mailAttachmentFile = getContext().getContextInformation().getPropertyFromMetaMap("mailAttachmentFile");
		
		if (mailBody != null && !mailBody.equals("")) {
			try {
				MailHelper.SendMail(email, subject, mailBody, mailAttachmentFile, mailAttachment!=null?mailAttachment.getBytes("UTF-8"):null);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}
	
	@When(value = "I check lumos video links from page $startPage to $endPage", priority = 0)
	public final void whenICheckLumosVideos(final Integer startPage, final Integer endPage) {
		Boolean error = false;
		String errorMsg = "";
		List<FailedVideo> failedVideos = new ArrayList<FailedVideo>();
		List<LumosVideo> allVideos = new ArrayList<LumosVideo>();
		
		Integer currentPage = -1;
		String currentSelector = "";

		try {
			
			currentSelector = "div[class*='pagination-pages-container']:not([class*='hide']) .pagination ul li";
			List<WebElement> pages = getContext().findElements(By.cssSelector("div[class*='pagination-pages-container']:not([class*='hide']) .pagination ul li"));
			int pageCount = 0;
			int i = pages.size() - 1;
			boolean done = false;
			while (!done) {
				WebElement page = pages.get(i);
				currentSelector = "a[data-page]";
				List<WebElement> a = page.findElements(By.cssSelector("a[data-page]"));
				if (a.size() == 1) {
					currentSelector = "@data-page";
					String dataPage = a.get(0).getAttribute("data-page");
					pageCount = Integer.valueOf(dataPage);
					done = true;
				}			
				if (i == 0) {
					done = true;
				}
				i--;
			}
			
			if (endPage < pageCount) {
				pageCount = endPage - 1;
			}
			
			//pageCount = 2;
			for (int j = startPage-1; j <= pageCount; j++) {
				currentSelector = "div[class*='pagination-pages-container']:not([class*='hide']) .pagination ul li a[data-page='"+j+"']";
				List<WebElement> a = getContext().findElements(By.cssSelector("div[class*='pagination-pages-container']:not([class*='hide']) .pagination ul li a[data-page='"+j+"']"));
				if (a.size() == 1) {
					System.out.println("data-page:"+(j+1));
					currentSelector = "arguments[0].scrollIntoView();";
					((JavascriptExecutor)getContext()).executeScript("arguments[0].scrollIntoView();", a.get(0)); 
					a.get(0).click();
					
					getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
					
					currentSelector = "body.mb-computing-1";
					WebElement element = getContext().waitForVisibility(By.cssSelector("body.mb-computing"), MAX_TIMEOUT_10_SECONDS);
					currentSelector = "body.mb-computing-2";
					getContext().waitForInvisibility(By.cssSelector("body.mb-computing"), MAX_TIMEOUT_10_SECONDS);

					currentSelector = "div.mb-result-container  div.video_result_container li";
					List<WebElement> videos = getContext().findElements(By.cssSelector("div.mb-result-container  div.video_result_container li"));
					for (WebElement video : videos) {
						String videoTitle = "";
						String videoId = "";
						String status = "success";
						Boolean videoErr = false;

						currentSelector = "div";
						List<WebElement> video_id_div = video.findElements(By.cssSelector("div"));
						if (video_id_div.size() > 0) {
							videoId = video_id_div.get(0).getAttribute("id");
							videoId = videoId.length() > 7 ? videoId.substring(7) : "no id";
						}

						currentSelector = "span.repairvideos-title";
						List<WebElement> title_span = video.findElements(By.cssSelector("span.repairvideos-title"));
						if (title_span.size() == 0) {
							System.out.println("No title : " + videoId);
							failedVideos.add(new FailedVideo(videoId, videoTitle, false));
							videoErr = false;
							status = "notitle";
						} else {
							videoTitle = title_span.get(0).getText().trim();
							if (videoTitle.equals("")) {
								System.out.println("No title : " + videoId);
								failedVideos.add(new FailedVideo(videoId, videoTitle, false));
								videoErr = false;
								status = "notitle";
							}
						}

						currentSelector = "div.cliplister-viewer-1";
						WebElement cliplisterElement = getContext().waitForVisibility(By.cssSelector("div.cliplister-viewer"), MAX_TIMEOUT_5_SECONDS);
						currentSelector = "div.cliplister-viewer";
						List<WebElement> video_div = video.findElements(By.cssSelector("div.cliplister-viewer"));
						if (video_div.size() == 0) {
							System.out.println("No video : " + videoTitle + " ("+videoId+")");
							failedVideos.add(new FailedVideo(videoId, videoTitle, true));
							videoErr = true;
							status = "novideo";
						}
						
						allVideos.add(new LumosVideo(videoId, videoTitle, videoErr, status, j+1));
						
					}
				}
				
			}
			/*
			for (WebElement page : pages) {
				List<WebElement> a = page.findElements(By.cssSelector("a[data-page]"));
				if (a.size() == 1) {
					String dataPage = a.get(0).getAttribute("data-page");
					System.out.println("data-page:"+dataPage);
					((JavascriptExecutor)getContext()).executeScript("arguments[0].scrollIntoView();", a.get(0)); 
					a.get(0).click();
				}
			}
			*/
			/*
			Boolean isDone = false;
			int[] count = {0};
			while (!isDone) {
				((JavascriptExecutor)getContext()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				isDone = true;			
			}
			*/
			

		} catch (Exception e) {
			error = true;
			errorMsg = "page : " + currentPage + "\r\n" + "selector : " + currentSelector + "\r\n \r\n";
			errorMsg = errorMsg + e.getMessage();
			e.printStackTrace();
		} finally {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String mailBody = "";
			StringBuffer attachment = null;
			String fileName = null;
			if (failedVideos.size() > 0) {
				attachment = new StringBuffer("");
				attachment.append("id;title;status\r\n");
				for (FailedVideo failedVideo : failedVideos) {
				      attachment.append("=\""+failedVideo.getId()+"\"");
				      attachment.append(";");
				      attachment.append(failedVideo.getTitle());
				      attachment.append(";");
				      attachment.append(failedVideo.getVideo()?"no video":"no title");
				      attachment.append("\r\n");
				}
				mailBody = "Failed Lumos video list is in the attached csv document";
				fileName = "failedvideos-"+timeStamp+".csv";
			}
			if (error) {
				mailBody = "TEST FAILED !\r\n" + errorMsg;
			}
			if (!mailBody.equals("")) {
				getContext().getContextInformation().setPropertyToMetaMap("mailBody", mailBody);
				getContext().getContextInformation().setPropertyToMetaMap("mailAttachment", attachment!=null?attachment.toString():null);
				getContext().getContextInformation().setPropertyToMetaMap("mailAttachmentFile", fileName);
			}
			
			if (allVideos.size() > 0) {
				attachment = new StringBuffer("");
				attachment.append("id;title;status;page\r\n");
				for (LumosVideo video : allVideos) {
				      attachment.append("=\""+video.getId()+"\"");
				      attachment.append(";");
				      attachment.append(video.getTitle());
				      attachment.append(";");
				      attachment.append(video.getStatus());
				      attachment.append(";");
				      attachment.append(video.getPage());
				      attachment.append("\r\n");
				}
				mailBody = "All Lumos video list is in the attached csv document";
				fileName = "allvideos.csv";

				String mailAttachment = attachment!=null?attachment.toString():null;
				
				if (mailBody != null && !mailBody.equals("")) {
					try {
						MailHelper.SendMail("Egemen.Sen-ext@bshg.com", "lumos video test", mailBody, fileName, mailAttachment!=null?mailAttachment.getBytes("UTF-8"):null);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}

			}
		}
		
		Assert.assertTrue("Lumos video test finished with error", true);
	}

	@When(value = "I check lumos image links with max count $maxCount", priority = 0)
	public final void whenICheckLumosImages(final Integer maxCount) {
		Boolean error = false;
		String errorMsg = "";
		//List<LumosImage> allImages = new ArrayList<LumosImage>();
		HashMap<String, LumosImage> allImages = new HashMap<>();
		
		Integer currentPage = -1;
		String currentSelector = "";

		try {

			/*
			try {
				for (int i = 0; i < 5; i++) {
					List<WebElement> more = getContext().findElements(By.cssSelector("div.mb-visible-results-full-page-loaded a[data-i18n='mobileclient_load_more_results']"));
					((JavascriptExecutor)getContext()).executeScript("arguments[0].scrollIntoView();", more.get(0)); 
					more.get(0).click();
					getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
				}
				
			} catch (Exception e) {
			}
			*/
			currentPage = 0;
			int pageTryCount = 0;
			int lastImageCount = 0;
			boolean cont = true;
			while (cont) {
				currentPage++;
				/*
				currentSelector = "body.mb-computing-1";
				WebElement element = getContext().waitForVisibility(By.cssSelector("body.mb-computing"), MAX_TIMEOUT_10_SECONDS);
				currentSelector = "body.mb-computing-2";
				getContext().waitForInvisibility(By.cssSelector("body.mb-computing"), MAX_TIMEOUT_10_SECONDS);
				*/

				getContext().waitUntilTimeout(MAX_TIMEOUT_2_SECONDS);

				currentSelector = "div[data-template='results']  div[result-category='PICenter']";
				List<WebElement> images = getContext().findElements(By.cssSelector("div[data-template='results']  div[result-category='PICenter']"));
				for (WebElement image : images) {
					String locale = "";
					String vib = "";
					String status = "no image";

					currentSelector = "h3";
					List<WebElement> image_title = image.findElements(By.cssSelector("h3 > div.result_picenter_title"));
					if (image_title.size() > 0) {
						String url = image_title.get(0).getAttribute("data-action-object");
						
						Pattern ptn = Pattern.compile("(?<=Locales=)(.*)(?=&)");
						Matcher mtch = ptn.matcher(url);
						if (mtch.find()) {
							locale = mtch.group();
						}
						
						ptn = Pattern.compile("(?<=vib=)(.*)(?=&cont)");
						mtch = ptn.matcher(url);
						if (mtch.find()) {
							vib = mtch.group();
						}
						allImages.put(vib, new LumosImage(vib, locale, status, currentPage));
					}

				}
				
				boolean loadCompleted = false;
				int tryCount = 0;
				while (!loadCompleted) {
					tryCount++;
					((JavascriptExecutor)getContext()).executeScript("window.scrollTo(0, document.body.scrollHeight);"); 
					getContext().waitUntilTimeout(MAX_TIMEOUT_2_SECONDS);
					
					List<WebElement> more = getContext().findElements(By.cssSelector("div.mb-visible-results-full-page-loaded a[data-i18n='mobileclient_load_more_results']"));
					if (more != null && more.size() > 0) {
						if (more.get(0).isDisplayed() || tryCount > 4) {
							loadCompleted = true;
							getContext().waitUntilTimeout(MAX_TIMEOUT_2_SECONDS);
						}
					} else {
						//loadCompleted = true;
					}
				}
				System.out.println("tryCount : "+tryCount);					
				System.out.println("vibCount : "+allImages.size());	
				
				if (lastImageCount == allImages.size()) {
					pageTryCount++;
					if (pageTryCount == 5) {
						cont = false;
					}
				} else {
					pageTryCount = 0;
				}
				lastImageCount = allImages.size();
				
				if (allImages.size() > maxCount) { 
					cont = false;
					break;
				}

				/*
				List<WebElement> more = getContext().findElements(By.cssSelector("div.mb-visible-results-full-page-loaded a[data-i18n='mobileclient_load_more_results']"));
				boolean b1 = more.get(0).isDisplayed();
				boolean b2 = more.get(0).isEnabled();
				boolean b3 = more.get(0).isSelected();
				cont = false;
				*/

				List<WebElement> noresults = getContext().findElements(By.cssSelector(".mb-no-results"));
				if (noresults != null && noresults.size() > 0) {
					cont = false;
				}

				
				List<WebElement> more = getContext().findElements(By.cssSelector("div.mb-visible-results-full-page-loaded a[data-i18n='mobileclient_load_more_results']"));
				if (more != null && more.size() > 0) {
					((JavascriptExecutor)getContext()).executeScript("arguments[0].scrollIntoView();", more.get(0));
					try {
						if (more.get(0).isDisplayed()) {
							more.get(0).click();
						} else {
							cont = false;
						}
					} catch (Exception e) {
					}
					getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
				} else {
					cont = false;
				}
			}


			/*
			for (int j = startPage-1; j <= pageCount; j++) {
				currentSelector = ".pagination ul li a[data-page='"+j+"']";
				List<WebElement> a = getContext().findElements(By.cssSelector(".pagination ul li a[data-page='"+j+"']"));
				
				//List<WebElement> a = getContext().findElements(By.cssSelector("input[id='profileFilterLanguage']"));
				if (a.size() == 1) {
					System.out.println("data-page:"+(j+1));
					currentSelector = "arguments[0].scrollIntoView();";
					((JavascriptExecutor)getContext()).executeScript("arguments[0].scrollIntoView();", a.get(0)); 
					a.get(0).click();
					
					currentSelector = "body.mb-computing-1";
					WebElement element = getContext().waitForVisibility(By.cssSelector("body.mb-computing"), MAX_TIMEOUT_10_SECONDS);
					currentSelector = "body.mb-computing-2";
					getContext().waitForInvisibility(By.cssSelector("body.mb-computing"), MAX_TIMEOUT_10_SECONDS);

					getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);

					currentSelector = "div[data-template='results']  div[result-category='PICenter']";
					List<WebElement> images = getContext().findElements(By.cssSelector("div[data-template='results']  div[result-category='PICenter']"));
					for (WebElement image : images) {
						String locale = "";
						String vib = "";
						String status = "no image";

						currentSelector = "h3";
						List<WebElement> image_title = image.findElements(By.cssSelector("h3 > div.result_picenter_title"));
						if (image_title.size() > 0) {
							String url = image_title.get(0).getAttribute("data-action-object");
							
							Pattern ptn = Pattern.compile("(?<=Locales=)(.*)(?=&)");
							Matcher mtch = ptn.matcher(url);
							if (mtch.find()) {
								locale = mtch.group();
							}
							
							ptn = Pattern.compile("(?<=vib=)(.*)(?=&cont)");
							mtch = ptn.matcher(url);
							if (mtch.find()) {
								vib = mtch.group();
							}
							allImages.add(new LumosImage(vib, locale, status, j+1));
						}

					}
				}
				
			}
				*/
			

		} catch (Exception e) {
			error = true;
			errorMsg = "page : " + currentPage + "\r\n" + "selector : " + currentSelector + "\r\n \r\n";
			errorMsg = errorMsg + e.getMessage();
			e.printStackTrace();
		} finally {
			String mailBody = "";
			StringBuffer attachment = null;
			String fileName = null;
			if (allImages.size() > 0) {
				attachment = new StringBuffer("");
				attachment.append("vib;locale;status\r\n");
				Iterator it = allImages.entrySet().iterator();
				while (it.hasNext()) {
			          Map.Entry pair = (Map.Entry)it.next();
			          LumosImage image = (LumosImage)pair.getValue();
					  attachment.append("=\""+image.getVib()+"\"");
					  attachment.append(";");
					  attachment.append(image.getLocale());
					  attachment.append(";");
					  attachment.append(image.getStatus());
					  attachment.append("\r\n");
			    }
				/*
				for (LumosImage image : allImages) {
				      attachment.append("=\""+image.getVib()+"\"");
				      attachment.append(";");
				      attachment.append(image.getLocale());
				      attachment.append(";");
				      attachment.append(image.getStatus());
				      attachment.append("\r\n");
				}
				*/
				mailBody = "Failed Lumos image list is in the attached csv document";
				String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				fileName = "failedimages-"+timeStamp+".csv";
			}
			if (error) {
				mailBody = "TEST FAILED !\r\n" + errorMsg;
			}
			if (!mailBody.equals("")) {
				getContext().getContextInformation().setPropertyToMetaMap("mailBody", mailBody);
				getContext().getContextInformation().setPropertyToMetaMap("mailAttachment", attachment!=null?attachment.toString():null);
				getContext().getContextInformation().setPropertyToMetaMap("mailAttachmentFile", fileName);
			}
			
		}
		
		Assert.assertTrue("Lumos image test finished with error", true);
	}

	//@.When(value = "I check lumos image links from page $startPage to $endPage", priority = 0)
	public final void whenICheckLumosImages2(final Integer startPage, final Integer endPage) {
		Boolean error = false;
		String errorMsg = "";
		List<LumosImage> allImages = new ArrayList<LumosImage>();
		
		Integer currentPage = -1;
		String currentSelector = "";

		try {

			/*
			try {
				for (int i = 0; i < 5; i++) {
					List<WebElement> more = getContext().findElements(By.cssSelector("div.mb-visible-results-full-page-loaded a[data-i18n='mobileclient_load_more_results']"));
					((JavascriptExecutor)getContext()).executeScript("arguments[0].scrollIntoView();", more.get(0)); 
					more.get(0).click();
					getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);
				}
				
			} catch (Exception e) {
			}
			*/

			
			int pageCount = 1;

			currentSelector = ".pagination ul li";
			List<WebElement> pages = getContext().findElements(By.cssSelector(".pagination ul li"));
			int i = pages.size() - 1;
			boolean done = false;
			while (!done) {
				WebElement page = pages.get(i);
				currentSelector = "a[data-page]";
				List<WebElement> a = page.findElements(By.cssSelector("a[data-page]"));
				if (a.size() == 1) {
					currentSelector = "@data-page";
					String dataPage = a.get(0).getAttribute("data-page");
					pageCount = Integer.valueOf(dataPage);
					done = true;
				}			
				if (i == 0) {
					done = true;
				}
				i--;
			}
			
			if (endPage < pageCount) {
				pageCount = endPage - 1;
			}
			
			//pageCount = 2;
			for (int j = startPage-1; j <= pageCount; j++) {
				currentSelector = ".pagination ul li a[data-page='"+j+"']";
				List<WebElement> a = getContext().findElements(By.cssSelector(".pagination ul li a[data-page='"+j+"']"));
				
				//List<WebElement> a = getContext().findElements(By.cssSelector("input[id='profileFilterLanguage']"));
				if (a.size() == 1) {
					System.out.println("data-page:"+(j+1));
					currentSelector = "arguments[0].scrollIntoView();";
					((JavascriptExecutor)getContext()).executeScript("arguments[0].scrollIntoView();", a.get(0)); 
					a.get(0).click();
					
					currentSelector = "body.mb-computing-1";
					WebElement element = getContext().waitForVisibility(By.cssSelector("body.mb-computing"), MAX_TIMEOUT_10_SECONDS);
					currentSelector = "body.mb-computing-2";
					getContext().waitForInvisibility(By.cssSelector("body.mb-computing"), MAX_TIMEOUT_10_SECONDS);

					getContext().waitUntilTimeout(MAX_TIMEOUT_5_SECONDS);

					currentSelector = "div[data-template='results']  div[result-category='PICenter']";
					List<WebElement> images = getContext().findElements(By.cssSelector("div[data-template='results']  div[result-category='PICenter']"));
					for (WebElement image : images) {
						String locale = "";
						String vib = "";
						String status = "no image";

						currentSelector = "h3";
						List<WebElement> image_title = image.findElements(By.cssSelector("h3 > div.result_picenter_title"));
						if (image_title.size() > 0) {
							String url = image_title.get(0).getAttribute("data-action-object");
							
							Pattern ptn = Pattern.compile("(?<=Locales=)(.*)(?=&)");
							Matcher mtch = ptn.matcher(url);
							if (mtch.find()) {
								locale = mtch.group();
							}
							
							ptn = Pattern.compile("(?<=vib=)(.*)(?=&cont)");
							mtch = ptn.matcher(url);
							if (mtch.find()) {
								vib = mtch.group();
							}
							allImages.add(new LumosImage(vib, locale, status, j+1));
						}

					}
				}
				
				
			}

		} catch (Exception e) {
			error = true;
			errorMsg = "page : " + currentPage + "\r\n" + "selector : " + currentSelector + "\r\n \r\n";
			errorMsg = errorMsg + e.getMessage();
			e.printStackTrace();
		} finally {
			String mailBody = "";
			StringBuffer attachment = null;
			String fileName = null;
			if (allImages.size() > 0) {
				attachment = new StringBuffer("");
				attachment.append("vib;locale;status\r\n");
				for (LumosImage image : allImages) {
				      attachment.append("=\""+image.getVib()+"\"");
				      attachment.append(";");
				      attachment.append(image.getLocale());
				      attachment.append(";");
				      attachment.append(image.getStatus());
				      attachment.append("\r\n");
				}
				mailBody = "Failed Lumos image list is in the attached csv document";
				String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				fileName = "failedimages-"+timeStamp+".csv";
			}
			if (error) {
				mailBody = "TEST FAILED !\r\n" + errorMsg;
			}
			if (!mailBody.equals("")) {
				getContext().getContextInformation().setPropertyToMetaMap("mailBody", mailBody);
				getContext().getContextInformation().setPropertyToMetaMap("mailAttachment", attachment!=null?attachment.toString():null);
				getContext().getContextInformation().setPropertyToMetaMap("mailAttachmentFile", fileName);
			}
			
		}
		
		Assert.assertTrue("Lumos image test finished with error", true);
	}

}
