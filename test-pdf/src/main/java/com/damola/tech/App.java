package com.damola.tech;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.damola.tech.model.BluePrint;
import com.damola.tech.utils.IFileGenerator;
import com.damola.tech.utils.PdfFileGenerator;
/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		String fields = "APPLICANTNAME,BVN,PAYMENTMETHOD,BIDAMOUNT,CURRENCY,FORMTYPE,ATTACHMENTID,SHIPPINGDETAILSID,FXFORMID,ACCOUNTNAME,ACCOUNTNUMBER,REQUESTTYPE,STAGE,STATUS,PROCESSSTAGE,CUSTOMEREMAIL,RELATIONALMANAGER,RELATIONALMANAGEREMAIL,BRANCHNAME,BIDPURPOSEID,CREATEDAT,MODIFIEDAT,DOMICILIARYACCOUNT,BIDAMOUNTCURRENCY,BIDRATE,BIDRATECURRENCY,UNALLOCATEDBIDAMOUNT,GOODSDESCRIPTION,FORMLOOKEDUP,PAYMENTMETHODREFNUMBER,SHIPPINGDOCUMENTAMOUNT,DOCREFNUMBER,PARTIALSHIPMENTAMOUNT,APPLICABLETRANSACTIONAMOUNT,INTEREST";
		List<String> dataFields = Arrays.asList(fields.split("\\s*,\\s*"));
		IFileGenerator generator = null;
		try {
			String home = System.getProperty("user.home");
			String filename = home + File.separator+"Desktop"+File.separator+"simple.pdf";
			generator = new PdfFileGenerator(filename);
			generator.open();
			generator.createActiveHeaders(getData(), dataFields);
			
			generator.appendActiveRow(getData(), dataFields);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(generator != null)
				generator.close();
		}
	}
	private static List<BluePrint> getData(){
		BluePrint bluePrint = new BluePrint();
		List<BluePrint> list = new ArrayList<BluePrint>();
		bluePrint.setApplicantName("Zainab Akeyinje");
		bluePrint.setBvn("12345676543");
		bluePrint.setPaymentMethod("26");
		bluePrint.setBidAmount("5000");
		bluePrint.setCurrency("USD");
		bluePrint.setFormType("FormM");
		bluePrint.setAttachmentId("40");
		bluePrint.setShippingDetailsId("48");
		bluePrint.setFxFormId("9");
		bluePrint.setAccountName("Akindele Oyindamola");
		bluePrint.setAccountNumber("12099482091");
		bluePrint.setRequestType("RETAIL");
		bluePrint.setStage("BANK_BRANCH");
		bluePrint.setStatus("PENDING_REVIEW");
		bluePrint.setProcessStage("FX_PHASE_ONE");
		bluePrint.setCustomerEmail("zainab.akeyinje@gmail.com");
		bluePrint.setRelationalManager("Akindele Oyindamola");
		bluePrint.setRelationalManagerEmail("oyindamola.akindele@gmail.com");
		bluePrint.setBranchName("Osborne Branch");
		bluePrint.setBranchId(1L);
		bluePrint.setBidPurposeId(2L);
		bluePrint.setCreatedAt("2019-30-06");
		bluePrint.setDomiciliaryAccount("2019204943");
		bluePrint.setBidAmountCurrency("USD");
		bluePrint.setBidRate("1.3");
		bluePrint.setBidRateCurrency("USD");
		bluePrint.setGoodsDescription("Eligible Items");
		bluePrint.setPaymentMethodRefNumber("89094359484343454353");
		bluePrint.setShippingDocumentAmount("8000");
		bluePrint.setPartialShipmentAmount("3000");
		bluePrint.setInterest("2");
		
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		list.add(bluePrint);
		
		return list;
	}
}
