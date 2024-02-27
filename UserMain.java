package maven_Demo.controller;

import java.util.Scanner;

import maven_Demo.dao.CrudData;
import maven_Demo.dto.Gadgets;
import maven_Demo.dto.User;



public class UserMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Throwable {
		
		CrudData crud=new CrudData();
		System.out.println("-:SaiShoppy:-\n");
		
		boolean check1=true;
		do {
			System.out.println("\n1.User");
			System.out.println("2.Gadgets");
			System.out.println("3.Exit");
			
			System.out.print("\nPlease select the option: ");
			int op1=sc.nextInt();
			switch(op1){
				case 1:{
					
					System.out.println("\n-:User:-\n");
					boolean check2=true;
									
					do {
						
						System.out.println("1.Registration");
						System.out.println("2.Login");
						System.out.println("3.Exit");
						
						System.out.print("\nPlease select the option: ");
						int op2=sc.nextInt();
						
						switch(op2) {
							case 1:{
								
								System.out.println("\n-:Registration:-\n");
								
								System.out.println("Please Enter the User Details: \n");
								
								System.out.println("Enter  id: ");
								int id=sc.nextInt();
								System.out.println("Enter Name:");
								String name=sc.next();
								System.out.println("Enter PhoneNumber: ");
								long phone=sc.nextLong();
								System.out.println("Enter Age: ");
								int age=sc.nextInt();
								System.out.println("Enter Gender: ");
								String gender=sc.next();
								System.out.println("Enter the Address:");
								String address=sc.next();
								System.out.println("Enter Email: ");
								String email=sc.next();
								System.out.println("Enter Password: ");
								String pwd=sc.next();
								System.out.println("Enter Wallet Amount: ");
								double wallet=sc.nextDouble();
								
								User user=new User( id, name,  email,  phone,  pwd,  gender, address,
										 wallet);
								crud.userData(user);
								System.out.println();
								
							}break;
							
							case 2:{
								
								System.out.println("\n-:Login:-\n");
								
								System.out.println("Enter Email: ");
								String email=sc.next();
								System.out.println("Enter Password: ");
								String pwd=sc.next();
								
								User user=new User(email,pwd);
								
								if(crud.login(user)) {
									
									crud.fetchGadgets();
									boolean check4=true;
									
									do {
										System.out.println("\nDo You Want Purchase the products: \n");
										System.out.println("1.Yes");
										System.out.println("2.No");
										System.out.println("\nPlease Select the Option: ");
										int op4=sc.nextInt();
										
										switch(op4) {
										case 1:{
											crud.fetchGadgets();
											System.out.println("\nSelect the Gadgets to purchase: ");
											int gadgetid=sc.nextInt();
											
											double res=crud.gadgetWallet(gadgetid);
											if(res<0) {
												System.out.println("You have insufficient balance.....");
												break;
											}
											boolean check5=true;
											do {
												System.out.println("\nPlease Select Yes to Complete your payment: \n");
												System.out.println("1.Yes");
												System.out.println("2.No");
												int op5=sc.nextInt();
												
												switch(op5) {
													case 1:{
														System.out.println("\nYou have successfully purchased your product..!!");
														crud.updateWallet(res);
														check5=false;
													}break;
													case 2:{
														check5=false;
													}break;
													default:{
														System.out.println("\nPlease select correct option......");
													}break;
												}
												
											}while(check5);
											
										}break;
										
										case 2:{
											
					
											check4=false;
											
										}break;
										
										default:{
											
											System.out.println("\nPlease select correct option.....\n");
											
										}break;
										
									}
									
									}while(check4);
									
									
								}
								
								else {
									System.out.println("\nLogin Failed");
									System.out.println("Incorrect Email or Password please provide correct details.....\n");
								}	
								
							}break;
								
							case 3:{
								
							
								check2=false;
								
							}break;
								
							default:{
								
								System.out.println("\nPlease Select Correct Option.....");
								System.out.println();
								
							}break;
						}
					}while(check2);
				}break;
				
				//
				case 2:{
					
					System.out.println("\n-:Gadgets:-\n");
					
					boolean check3=true;
					do {
						
						System.out.println("\n1.Save Gadget Details");
						System.out.println("2.Update Gadget Detalis");
						System.out.println("3.Delete Gadget details");
						System.out.println("4.Fetch Gadget details");
						System.out.println("5.Exit");
						System.out.print("\nPlease select the option: ");
						int op3=sc.nextInt();
						
						switch(op3) {
						
							case 1:{
								
								System.out.println("\n-:Save Gadget:-\n");
								
								System.out.println("Please enter the gadget information: \n");
								System.out.println("Enter gadget id: ");
								int id=sc.nextInt();
								System.out.println("Enter gadget name: ");
								String gName=sc.next();
								System.out.println("Enter gadget brand name: ");
								String gBrand=sc.next();
								System.out.println("Enter gadget price: ");
								double price=sc.nextDouble();
								System.out.println("Enter gadget warranty: ");
								int warranty=sc.nextInt();
								System.out.println("Enter gadget colour: ");
								String colour=sc.next();
								
								Gadgets gadget=new Gadgets(id,gName,gBrand,price,warranty,colour);
								crud.saveGadget(gadget);
								System.out.println();
								
							}break;
							
							case 2:{
								
								System.out.println("\n-:Update Gadget:-\n");
								System.out.println("Please enter the gadget information: \n");
								System.out.println("Enter gadget id: ");
								int id=sc.nextInt();
								System.out.println("Enter gadget name: ");
								String gName=sc.next();
								System.out.println("Enter gadget brand name: ");
								String bName=sc.next();
								System.out.println("Enter gadget price: ");
								double price=sc.nextDouble();
								System.out.println("Enter gadget warranty: ");
								int warranty=sc.nextInt();
								System.out.println("Enter gadget colour: ");
								String colour=sc.next();
								System.out.println("\nEnter gadget name to be updated: ");
								String upGName=sc.next();
								
								Gadgets gadget=new Gadgets(id,gName,bName,price,warranty,colour,upGName);
								crud.updateGadget(gadget);
								System.out.println();
								
							}break;
							
							case 3:{
								
								System.out.println("\n-:Delete Gadget:-");
								System.out.println("Enter Gadget Name to be Deleted: ");
								String dGName=sc.next();
								Gadgets gadget=new Gadgets(dGName);
								crud.deleteGadget(gadget,dGName);
								System.out.println();
								
							}break;
							
							case 4:{
								
								System.out.println("\n-:Fetch Gadgets:-");
								crud.fetchGadgets();
								System.out.println();
								
							}break;
							
							case 5:{
								
								//System.out.println("Thank You.....");
								check3=false;
								
							}break;
							
							default:{
								
								System.out.println("\nPlease Select Correct Option.....");
								System.out.println();
								
							}break;
						}
						
					}while(check3);
				}break;
				
				case 3:{
					System.out.println("\nThank You.....");
					check1=false;
				}break;
				
				default:{
					System.out.println("\nPlease Select Correct Option.....");
					
				}break;
				
			}
		}while(check1);
	}
}
