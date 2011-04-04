package cn.edu.nju.software.timemachine.test.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import cn.edu.nju.software.timemachine.entity.*;
import cn.edu.nju.software.timemachine.service.*;

public class Init {
	
	public static void initDatabase(IAlbumService<Album> albumService,ICategoryService<Category> categoryService,
			                        ICommentService<SimpleComment> commentService,IFriendService<Friend> friendService,
			                         IMessageService<Message> messageService,IPictureService<Picture> pictureService,IUserService<User> userService,IRoleService<Role> roleService){
		
		Role userRole = new Role();
		userRole.setDateCreated(new Date());
		userRole.setName("user");
		roleService.addRole(userRole);
		
		Role adminRole = new Role();
		adminRole.setDateCreated(new Date());
		adminRole.setName("admin");
		roleService.addRole(adminRole);
		
		Friend friend = new Friend();
		friend.setCategory(userService.getUser(1).getCategoryList().get(0));
		friend.setDateCreated(new Date());
		friend.setNikename("ljj");
		friend.setUser(userService.getUser(2));
		friendService.addFriend(friend, userService.getUser(2).getCategoryList().get(0));
		
		Friend friend2 = new Friend();
		friend2.setCategory(userService.getUser(1).getCategoryList().get(0));
		friend2.setDateCreated(new Date());
		friend2.setNikename("ljj");
		friend2.setUser(userService.getUser(3));
		friendService.addFriend(friend2, userService.getUser(3).getCategoryList().get(0));
		
		
		
		/*
		User user1=new User();
		user1.setEmail("a@gmail.com");
		user1.setName("ljj");
		user1.setPassword("123456");
		Calendar c=new GregorianCalendar();
		c.set(2000, 0, 1);
		user1.getUserMeta().setBirthday(c);
		user1.getUserMeta().setCity("nanjing");
		userService.addUser(user1);
		
		User user2= new User();
		user2.setEmail("b@gmail.com");
		user2.setName("lhh");
		user1.setPassword("234");
		userService.addUser(user2);
		
		Friend friend1 =new Friend();
		friend1.setCategory(userService.getUser(1).getCategoryList().get(0));
		friend1.setNikename("xiaohh");
		friend1.setUser(userService.getUser(2));
		friendService.addFriend(friend1,userService.getUser(2).getCategoryList().get(0));
		
		Album album = new Album();
		album.setName("MyAlbum");
		album.setOwner(userService.getUser(1));
		albumService.addAlbum(album);
		
		Picture picture = new Picture();
		picture.setAlbum(album);
		
		
		//添加了用户lhh
		addUserTest(userService,"利好换","dingli886@sina.com","123456",new GregorianCalendar(1991, 8, 30), "Changsha", "China", "male", "I'm lhh");

		//添加与lhh相同用户名用户lhh_same_usrname
		addUserTest(userService,"lhh","suck@sina.com","123456",new GregorianCalendar(1991, 8, 20), "Shanghai", "China", "female", "I'm not lhh");

		//添加与lhh相同邮箱用户lhh_same_email
		addUserTest(userService,"lgl","dingli886@sina.com","1234567",new GregorianCalendar(1992, 8, 20), "Beijing", "China", "male", "I'm not lhh too!");

		//添加了用户LJJ
		addUserTest(userService,"ljj", "ljj@gmail.com", "ljj213", new GregorianCalendar(1990, 10, 22), "Zhongshan", "China", "male", "I love SSH！");

		addUserTest(userService,"qc", "qc@gmail.com", "ljj213", new GregorianCalendar(1993, 10, 22), "Zhongshan", "China", "male", "I love SSH！");
		
		//根据邮箱查找用户
		searchUserByEmailTest(userService, "dingli886@sina.com");

		//根据用户名查找用户
		User lhh=searchUserByNameTest(userService, "lhh").get(0);
		
		Role userRole = new Role();
		userRole.setDateCreated(new Date());
		userRole.setName("user");
		roleService.addRole(userRole);

		Role adminRole = new Role();
		adminRole.setDateCreated(new Date());
		adminRole.setName("admin");
		roleService.addRole(adminRole);

		User user1=new User();
		user1.setEmail("a@gmail.com");
		user1.setName("ljj");
		user1.setPassword("123456");
		Calendar c=new GregorianCalendar();
		c.set(2000, 0, 1);
		user1.getUserMeta().setBirthday(c);
		user1.getUserMeta().setCity("nanjing");
		userService.addUser(user1);

		User user2= new User();
		user2.setEmail("b@gmail.com");
		user2.setName("lhh");
		user1.setPassword("234");
		userService.addUser(user2);

		Category category = new Category();
		category.setName("default");
		category.setOwner(userService.getUser(1));
		categoryService.addCategory(category);

		Category category2 = new Category();
		category2.setName("default");
		User u = userService.getUser(2);
		category2.setOwner(u);
		categoryService.addCategory(category2);

		Friend friend1 =new Friend();
		friend1.setCategory(userService.getUser(1).getCategoryList().get(0));
		friend1.setNikename("xiaohh");
		friend1.setUser(userService.getUser(2));

		friendService.addFriend(friend1, userService.getUser(2).getCategoryList().get(0));
		System.out.println(friend1.getCategory().getOwner().getId()+" "+friend1.getUser().getId());

		//随机产生15个用户
		for(int i=1;i<16;i++){
		addUserTest(userService,"lhh"+String.valueOf(i),"user"+String.valueOf(i)+"@sina.com","user"+String.valueOf(i),new GregorianCalendar(1991, 8, i), "City"+String.valueOf(i%5), "Country"+String.valueOf(i%3), i%2==0?"male":"female", "I'm user"+String.valueOf("i"));
		}
		//System.out.println("执行第"+times+"次");
		//每个用户添加一个相册
		for(int j=1;j<16;j++){
		addAlbumTest(albumService,userService.getUser(j),"Album"+String.valueOf(j));
		}
		//每个用户添加若干个好友分组
		for(int k=1;k<16;k++){
		if(k%2==0) addCategoryTest(categoryService, userService.getUser(k), "classmates");
		if(k%3==0) addCategoryTest(categoryService, userService.getUser(k), "teachers");
		if(k%5==0) addCategoryTest(categoryService, userService.getUser(k), "colleagues");
		}
		addFriendToRandomGroupTest(friendService, userService.getUser(12), userService.getUser(14), 
		userService.getUser(12).getName()+"'s Friend No."+String.valueOf(14));
		//for(int i=0;i<userService.getUser(15).getCategoryList().size();i++)
		// System.out.println("lhh15: 分组"+userService.getUser(15).getCategoryList().get(i).getName());
		for(int m=1;m<16;m++){
		int random=(int)(Math.random()*16);
		System.out.println("rashjasj"+random);
		for(int index=1;index<5;index++)
		addFriendToRandomGroupTest(friendService, userService.getUser(m), userService.getUser((int)(Math.random()*13)), userService.getUser(m).getName()+"'s Friend No."+String.valueOf(index));
		}
		
		//添加了用户lhh
		addUserTest(userService,"lhh","dingli886@sina.com","123456",new GregorianCalendar(1991, 8, 30), "Changsha", "China", "male", "I'm lhh");

		//添加与lhh相同用户名用户lhh_same_usrname
		addUserTest(userService,"lhh","suck@sina.com","123456",new GregorianCalendar(1991, 8, 20), "Shanghai", "China", "female", "I'm not lhh");

		//添加与lhh相同邮箱用户lhh_same_email
		addUserTest(userService,"lgl","dingli886@sina.com","1234567",new GregorianCalendar(1992, 8, 20), "Beijing", "China", "male", "I'm not lhh too!");

		//添加了用户LJJ
		addUserTest(userService,"ljj", "ljj@gmail.com", "ljj213", new GregorianCalendar(1990, 10, 22), "Zhongshan", "China", "male", "I love SSH！");


		//根据邮箱查找用户
		searchUserByEmailTest(userService, "dingli886@sina.com");

		//根据用户名查找用户
		User lhh=searchUserByNameTest(userService, "lhh").get(0);
		*/
		

	}
	
	
/*		
		private static List<User> searchUserByEmailTest(IUserService<User> userService,String email){
			List<User> user_list=(List<User>) userService.searchUserByEmail(email);
			for(int i=0;i<user_list.size();i++){
			System.out.print(user_list.get(i).getName());
			}
			System.out.println();
			return user_list; 
			}
			private static List<User> searchUserByNameTest(IUserService<User> userService,String name){
			List<User> user_list=userService.searchUserByName("lhh");
			for(int i=0;i<user_list.size();i++){
			System.out.print(user_list.get(i).getEmail());
			}
			System.out.println();
			return user_list;
			}
			private static boolean addUserTest(IUserService<User> userService,String username, String email, String password,
			Calendar birthday, String city, String country, String sex,
			String otherstuff) {
			User lhh = new User();
			lhh.setEmail(email);
			lhh.setName(username);
			lhh.setPassword(password);
			lhh.getUserMeta().setBirthday(birthday);
			lhh.getUserMeta().setCity(city);
			lhh.getUserMeta().setCountry(country);
			lhh.getUserMeta().setSex(sex);
			lhh.getUserMeta().setOtherStuff(otherstuff);
			boolean flag=userService.addUser(lhh);
			if(flag) System.out.println("添加用户"+lhh.getName()+"/"+lhh.getEmail()+" 成功!");
			else System.out.println("添加用户"+lhh.getName()+"/"+lhh.getEmail()+" 失败!");
			return flag;
			}

			private static boolean addAlbumTest(IAlbumService<Album> albumService,User user,String name){
			boolean flag=false;
			Album album = new Album();
			album.setName(name);
			album.setOwner(user);
			flag=albumService.addAlbum(album);	
			System.out.println("用户"+user.getName()+"添加相册"+album.getName()+new String(flag?"成功！":"失败！"));
			return flag;
			}

			private static boolean addCategoryTest(ICategoryService<Category> categoryService,User user,String cate_name){
			boolean flag=false;
			Category cater=new Category();
			cater.setName(cate_name);
			cater.setOwner(user);
			flag=categoryService.addCategory(cater);
			System.out.println(user.getName()+"添加分组："+cater.getName()+new String(flag?"成功！":"失败！"));
			return flag;
			}
			private static boolean addFriendToRandomGroupTest(IFriendService<Friend> friendService,User invitor,User invitee,String nickname){
			boolean flag=false;
			Friend friend=new Friend();
			int num_of_groups=invitor.getCategoryList().size();
			friend.setCategory(invitor.getCategoryList().get(0));
			friend.setNikename(nickname);
			friend.setUser(invitee);	
			Category category2 = new Category();
			category2.setName("default");
			User u = userService.getUser(2);
			category2.setOwner(u);
			categoryService.addCategory(category2);
			//flag=friendService.addFriend(friend, invitee.getCategoryList().get(0));
			System.out.println(invitor.getName()+"添加好友："+invitee.getName()+new String(flag?"成功！":"失败！"));
			return flag;
			}*/

}
