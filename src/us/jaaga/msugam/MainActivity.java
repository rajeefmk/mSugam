package us.jaaga.msugam;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.andreabaccega.widget.FormEditText;

public class MainActivity extends Activity {
	
	FormEditText mOtherPartyTin ,mInvoiceNo ,mTaxableVal ,mVATVal ,mOtherVal ,mPlace;
	Spinner mSpinnerType, mSpinnerCategory;
	String fOtherPartyTin ,fInvoiceNo ,fTaxableVal ,fVATVal ,fOtherVal ,fCommCode ,fPlace;
	String Message ,Number, fsptype,fspcateg, finalSpinnerType, finalSpinnerCategory ;
	Button mButton;
	AutoCompleteTextView mCommCode;
	//CustomAutoCompleteTextView mCommCode;
	//public double finalCommodityValue=0;
	String formattedCommodityValue, mCommodityValue;
	//double finalCommodityValue = 0;
	private static final String[] CommodityNames = new String[] {
		"ADHESIVES OF ALL KINDS-1.00",
		"AGRICULTURAL AND HORTICULTURAL IMPLEMENTS-2.00",
		"ANIMAL AND ITS PRODUCTS-3.00",
		"ARECANUT IN ALL FORMS-4.00",
		"ARMS AND EXPLOSIVES-5.00",
		"AUDIO, MUSIC AND VIDEO SYSTEMS/EQUIPMENTS/PARTS/ CDS/CASSETTES/TAPES-6.00",
		"AERO/JET PLANES, HELICAOPTERS AND OTHER FLYING MACHINES/PARTS-7.00",
		"BABY FOODS AND FOOD SUPPLEMENTS-8.00",
		"BAKERY PRODUCTS AND CONFECTIONERY-9.00",
		"BATTERIES OF ALL KINDS AND PARTS-10.00",
		"BICYCLES AND PARTS-11.00",
		"BISCUITS-12.00",
		"BRICKS AND TILES OF ALL KINDS-13.00",
		"CARPETS-14.00",
		"CEMENT AND ITS PRODUCTS AND MIXTURES-15.00",
		"CEREALS AND PULSES-16.00",
		"CHEMICALS-17.00",
		"COAL AND COKE-18.00",
		"COFFEE SEEDS AND COFFEE-19.00",
		"COIR PRODUCTS-20.00",
		"COMPUTER OF ALL KINDS, PERIPHERALS,CONSUMABLES AND SOFTWARE-21.00",
		"COOLING SYSTEMS AND PARTS-22.00",
		"COTTON OF ALL KINDS-23.00",
		"DAIRY PRODUCTS-24.00",
		"DIESEL ENGINES AND PARTS-25.00",
		"DRY FRUITS OTHER THAN CASHEW-26.00",
		"CASHEW-27-26.01",
		"EDIBLE OILS INCLUDING VANASPATHI-27.00",
		"ELECTRICAL GOODS OF ALL KINDS (HOME/INDUSTRIAL)-28.00",
		"ELECTRONIC GOODS-29.00",
		"FERTILIZERS AND AGRO CHEMICALS-30.00",
		"FIBRE GLASS AND ITS ARTICLES-31.00",
		"FIRE FIGHTING EQUIPMENTS-32.00",
		"FIREWORKS-33.00",
		"FOOD AND DRINKS-34.00",
		"FOOTWEAR OF ALL KINDS AND ACCESSORIES-35.00",
		"FOREST PRODUCES-36.00",
		"FURNITURE OF ALL KINDS-37.00",
		"GLASS AND GLASS ARTICLES-38.00",
		"HANDICRAFTS OF METALS AND IVORY AND SANDALWOOD ARTICLES-39.00",
		"HARDWARE AND PAINTS-40.00",
		"ICE CREAM AND ICE-41.00",
		"INCENSE STICKS-42.00",
		"INDUSTRIAL GASES-43.00",
		"IRON AND STEEL AND ITEMS THEREOF-44.00",
		"SCRAP OF FERROUS AND NON-FERROUS METALS-44.01",
		"JAGGERY-45.00",
		"JEWELLERY AND ALL KINDS OF ARTICLES OF GOLD, SLIVER, PLATINUM-46.00",
		"KITCHEN-WARE (STOVES, FLASKS, CHINAWARE, CUTLERY, ETC)-47.00",
		"LEASING OF GOODS OF ALL KINDS-48.00",
		"LEATHER GOODS OF ALL KINDS EXCLUDING FOOTWEAR-49.00",
		"LIFTS AND ELEVATORS-50.00",
		"LOCOMOTIVES AND PARTS THEREOF-51.00",
		"MACHINERY AND PARTS-52.00",
		"MEDICINAL AND PHARMACEUTICAL PREPARATIONS , EQUIPMENTS-.53.00",
		"MINERALS AND ORES-54.00",
		"AUTOMOBILES/MOTOR VEHICLES OF ALL KINDS AND PARTS THEREOF-55.00",
		"MUSICAL INSTRUMENTS-56.00",
		"NARCOTICS-57.00",
		"NON-EDIBLE OIL-58.00",
		"NON-FERROUS METALS (ALUMINIUM, BRONZE, COPPER, BRASS, ZINC, LEAD, MERCURY) AND THEIR PRODUCTS-59.00",
		"OIL SEEDS AND OIL CAKE-60.00",
		"COCONUT,COPRA AND DESICCATED COPRA-60.01",
		"OPTICAL GOODS (BINACULARS, SPECTACLES, SUNGLASSES, MICRO/TELE SCOPES)-61.00",
		"PACKING MATERIALS-62.00",
		"PAPER IN ALL FORMS AND PAPER WASTE-63.00",
		"PETROLEUM PRODUCTS-64.00",
		"PHOTO, FILMS, CAMERAS AND THEIR PARTS, PHOTO/CINEMATOGRAPHIC GOODS-65.00",
		"PIPES AND FITTINGS-66.00",
		"PLASTIC ARTICLES-67.00",
		"PLYWOOD AND OTHER SHEETS , BOARDS-68.00",
		"PRINTED MATERIALS-69.00",
		"PUMPS, PUMPSETS AND PARTS-70.00",
		"READYMADE GARMENTS, TEXTILE MADE UPs AND HOSIERY-71.00",
		"RECTIFIED SPIRIT AND OTHERS-72.00",
		"RENEWABLE ENERGY DEVICES AND BIO-FUELS-73.00",
		"ROOFING MATERIALS-74.00",
		"RUBBER ARTICLES-75.00",
		"SAND-76.00",
		"SANITARY GOODS AND FITTINGS-77.00",
		"SIGN BOARDS AND HOARDINGS-78.00",
		"SHIIPS AND BOATS-79.00",
		"SPICES-80.00",
		"CARDAMOM-80.01",
		"PEPPER-80.02",
		"SPORTS GOODS-81.00",
		"STATIONERY ARTICLES-82.00",
		"MARBLES , SLABS AND TILES-83.00",
		"GRANITE BLOCKS,SLABS AND TILES-83.01",
		"SUGAR AND SUGARCANE-84.00",
		"TEA-85.00",
		"TELEPHONES-86.00",
		"TEXTILES AND FABRICS-87.00",
		"TIMBER AND WOOD-88.00",
		"TOBACCO AND ITS PRODUCTS-89.00",
		"TOILET ARTICLES-90.00",
		"TOYS OF ALL KINDS-91.00",
		"WATCHES AND CLOCKS-92.00",
		"WEIGHTS AND MEASURES-93.00",
		"WORKS CONTRACT-94.00",
		"YARN-95.00",
		"OTHERS-99.99"};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       // final String[] CommodityList = getResources().getStringArray(R.array.commodity_code);
        
        //Layout Element Inflators
        
        mOtherPartyTin = (FormEditText) findViewById(R.id.OtherPartyTin);
        mInvoiceNo = (FormEditText) findViewById(R.id.InvoiceNo);
        mTaxableVal = (FormEditText) findViewById(R.id.TaxableVal);
        mVATVal = (FormEditText) findViewById(R.id.VATVal);
        mOtherVal = (FormEditText) findViewById(R.id.OtherVal);
        //mCommCode = (EditText) findViewById(R.id.CommCode);
        mPlace = (FormEditText) findViewById(R.id.Place);
        
        //Inflating the Commodity code AutoCompleteTextView
        
        mCommCode = (AutoCompleteTextView) findViewById(R.id.CommCode);
        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.my_custom_textview , CommodityNames);
        mCommCode.setAdapter(mArrayAdapter);
        
        mCommCode.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				
				Toast.makeText(getApplicationContext(),(CharSequence)arg0.getItemAtPosition(arg2), Toast.LENGTH_LONG).show();
				
				
				mCommodityValue = arg0.getItemAtPosition(arg2).toString();
				String mArray[] = mCommodityValue.split("-");
				formattedCommodityValue = mArray[1];
				
			}
		});
        
        
      //Getting data from Spinner Type
        
           //Spinner layout being inflated
	       mSpinnerType = (Spinner) findViewById(R.id.SpinnerType);
	       
	       //Adapter which supplies the data to the spinner is defined here.
	       ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(this, R.array.type_list, 
	    		   																android.R.layout.simple_spinner_item);
	       
	       adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	       
	       //OnItemSelectedListener is implemented and actions based on selection is made
	       mSpinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {
	
				@Override
				public void onItemSelected(AdapterView<?> parent, View view, int pos,
						long id) {
					
					fsptype = parent.getItemAtPosition(pos).toString();
					
					String marray[] = fsptype.split("-");
					
					finalSpinnerType = marray[0];
					
					
				}
		
				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}
		  });
	        
       //Getting selected item from Spinner Category
       
	       mSpinnerCategory = (Spinner) findViewById(R.id.SpinnerCategory);
	       
	       ArrayAdapter<CharSequence> adapterCategory= ArrayAdapter.createFromResource(this, R.array.category_list,
	    		   														android.R.layout.simple_spinner_item);
       
	       adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	       
	       mSpinnerCategory.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long arg3) {
				
				  fspcateg = parent.getSelectedItem().toString();
				  
			      String marray2[] = fspcateg.split("-");
			       
			      finalSpinnerCategory = marray2[0];
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
		   });
        
        mButton = (Button) findViewById(R.id.submitButton);
        
        mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Getting data from Other fields
				fOtherPartyTin = mOtherPartyTin.getText().toString().trim();
		        fInvoiceNo = mInvoiceNo.getText().toString().trim();
		        fTaxableVal = mTaxableVal.getText().toString().trim();
		        fVATVal = mVATVal.getText().toString().trim();
		        fOtherVal = mOtherVal.getText().toString().trim();
		        //fCommCode = mCommCode.getText().toString().trim();
		        
		        fPlace = mPlace.getText().toString().trim();
		        
		        Message = "KSR " + finalSpinnerType + " " + finalSpinnerCategory + " " +
	        			fOtherPartyTin + " " + fInvoiceNo + " " + fTaxableVal + " " + 
	        			fVATVal + " " + fOtherVal + " " + formattedCommodityValue + " " + " " + fPlace;
	        
	        
		        //Number = "09212357123"; 
		        Number = "09663845414";

				
				SmsManager sms = SmsManager.getDefault();
				
				sms.sendTextMessage(Number, null, Message, null, null);
				
				Toast.makeText(MainActivity.this, "Accepted: Sending Message...", Toast.LENGTH_LONG).show();
				
				
			}
		});
    }
    
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
    
}
