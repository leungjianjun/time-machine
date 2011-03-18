package cn.edu.nju.software.timemachine.test.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AlbumServiceTest.class,
	CategoryServiceTest.class,
	CommentServiceTest.class,
	FriendServiceTest.class,
	MessageServiceTest.class,
	PictureServiceTest.class,
	UserServiceTest.class
})
public class ServiceTestSuite {

}
