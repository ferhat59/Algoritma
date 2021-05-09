package hash�dev;

import java.util.Arrays;

class hash{
	
	double alfa;
	int size;
	kisi [] hashtable;
	float yuk;
	public hash(int boyut){
		
		hashtable= new kisi [boyut];
		
	}
	
	public void goster() {
		int i =0;
		  while(i<hashtable.length) {
			  if(hashtable[i]!=null)
			  System.out.print("\nBucket "+ (i) +": "+ hashtable[i].toString()) ;
              i++;
		  }
		  System.out.println("\ntablo boyutu :" +hashtable.length);
	          
	        
	
	}
	
	public void ekle(String numara,String ad,String soyad){
	
		 int had = (hashd(ad));
		 if((hashtable[had]) == null ) {
			 hashtable[had]=new kisi(numara,ad,soyad);
			 size++;	
			 yuk=(float) size/hashtable.length;
		 }
		 else {
			 
			 int s=1;
			 int e=2;
			 int d=had; 
			 //bo� yer aramaya ba�l�yor
			 while(d<hashtable.length) {		 
				 if(hashtable[d]==null) {
					 //buldu
					 hashtable[d]=new kisi(numara,ad,soyad);
					 
					 size++;
					 yuk=(float) size/hashtable.length;
					
					break;
				 }
				 else {
					 //bulamad� hesaplamaya devam
					 d=(d+s^e)%hashtable.length;
					 s=s+1;
					 
					 
					 
				 }
			
					 }
				
			 	 
		 if(yuk>0.600) {
			 //tablo dolmaya ba�lad� yeni tabloya ge�me vakti
				  yeni_tablo();
			 }}			 
	}
	public void yeni_tablo() {
		
		
		kisi yedekdizi[] =new kisi[hashtable.length];
		 yedekdizi=hashtable.clone();
		 hashtable = new kisi[boyutbul(hashtable.length)];
		 size =0;
		for(int k=0;k<yedekdizi.length;k++) {
			if(yedekdizi[k]!=null) {
				ekle(yedekdizi[k].numara,yedekdizi[k].ad,yedekdizi[k].soyad);
			}
		}
				
		

		}
		
	public int boyutbul(int w) {
		int s;
		int i;
		int k2;
		//say�n�n 2 kat�na en yak�n asal say�y� d�nd�r�r;
		for( k2=w*2;w<k2;k2--) {
			s=0;
			for(int j = 2;j<k2;j++) {
				if((k2%j)==0) s = s+1;
			}
			if (s==0) break; 
		}
		System.out.println("yeni de�er :" +k2);
	
		return k2;
	}
	
	public int hashd(String x ){
			//hash de�erini bulmak i�in ba�tan yazamad�m, var olan metodu kulland�m;
        	int hashVal = x.hashCode();        	
        	hashVal =hashVal% hashtable.length;
        	if (hashVal < 0)
            	hashVal=hashVal*-1;
        	
        	return hashVal;
    }
	public void sil(String x) {

		
			int deleteIndex = arama(x);
				if(deleteIndex==-1) {
					System.out.println("B�yle bir de�er yokk o y�zden silemiyorum");
				}
				else {
					hashtable[deleteIndex]=null;
					System.out.println("silenen de�er : " +x +" indis numaras�: "+ deleteIndex);
					size--;
				}

		}
		
	
	public int arama(String x) {
		
		int hashv=hashd(x);
		 int s=1;
		 int e=2;
		 int d=hashv;
		 int deger=0;
	while(true) {
		
			
		if(hashtable[d]!=null) {
			if((hashtable[d].ad).equals(x)) {
				System.out.println("\nde�er bulundu :" + d+". indexite \nbilgiler:  "+ hashtable[d].toString());
				return d;
				
				
			
				
			}
			else {
				 d=(d+s^e)%hashtable.length;
				 s=s+1;
				 deger++;
			}
			
			
		}
		else {
			 d=(d+s^e)%hashtable.length;
			 s=s+1;
			 deger++;
			
		}
		if(deger>hashtable.length) {
			System.out.println("tabloda b�yle bir de�er yok "+deger);
			return -1;
			
		}
	}
	
	
	}
}
