package com.yc.web.tasks;

import org.springframework.stereotype.Component;

@Component
public class ClearMemoryTask {
	public void clear() {
		System.out.println("清理任务...");
	}
}
