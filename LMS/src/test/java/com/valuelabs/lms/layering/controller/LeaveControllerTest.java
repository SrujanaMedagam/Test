package com.valuelabs.lms.layering.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.valuelabs.lms.bean.EmployeeLeavesInfo;
import com.valuelabs.lms.configuration.LmsConfiguration;
import com.valuelabs.lms.configuration.test.TestContextService;
import com.valuelabs.lms.service.ApplyLeaveService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContextService.class, LmsConfiguration.class})
@WebAppConfiguration
public class LeaveControllerTest {
	
private MockMvc mockMvc;
	
		@Autowired
		private ApplyLeaveService applyLeaveService;
	
		@Autowired
	    private WebApplicationContext webApplicationContext;
	 
	    @Before
	    public void setUp() {
	        //We have to reset our mock between tests because the mock objects
	        //are managed by the Spring container. If we would not reset them,
	        //stubbing and verified behavior would "leak" from one test to another.
	    //    Mockito.reset(todoServiceMock);
	 
	        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	    }
	    
	    @Test	    
	    public void testApplyLeave() throws Exception
	    {
	    	ObjectMapper mapper = new ObjectMapper();
	    	String leaveData="";
	    	String response="";
			//For testing
	    	EmployeeLeavesInfo empLeaveInfoBean= new EmployeeLeavesInfo();
	    	empLeaveInfoBean.setEid("vlsp2577");
	    	empLeaveInfoBean.setFromDate("2017/02/01");
	    	empLeaveInfoBean.setToDate("2017/02/04");
	    	empLeaveInfoBean.setNoOfDays(3);
	    	empLeaveInfoBean.setReason("new2");

			try {
				List<String> list= new ArrayList<>();
				list.add("passed");
				//Convert object to JSON string and save into file directly

				//Convert object to JSON string
				leaveData = mapper.writeValueAsString(empLeaveInfoBean);
				response = mapper.writeValueAsString(list);
				System.out.println(leaveData);

				//Convert object to JSON string and pretty print
				leaveData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(empLeaveInfoBean);
				response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
				System.out.println(leaveData);
				System.out.println(response);


			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mockMvc.perform(post("/leave/applyleave")
					.contentType(MediaType.APPLICATION_JSON)
			        .content(leaveData))
			        .andExpect(status().isOk())
			.andExpect(content().json(response));
	    	
	    }

}
