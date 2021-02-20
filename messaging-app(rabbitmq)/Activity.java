package com.emanuelan.messaging_app;

public class Activity {

		private String start_time;
		private String end_time;
		private String activity;

		public Activity(String start_time, String end_time, String activity) {
			this.start_time = start_time;
			this.end_time = end_time;
			this.activity = activity;
		}

		public String getStart_time() {
			return start_time;
		}

		public void setStart_time(String start_time) {
			this.start_time = start_time;
		}

		public String getEnd_time() {
			return end_time;
		}

		public void setEnd_time(String end_time) {
			this.end_time = end_time;
		}

		public String getActivity() {
			return activity;
		}

		public void setActivity(String activity) {
			this.activity = activity;
		}

		@Override
		public String toString() {
			return "\"activity\":\""+activity+"\",\n"+"\"start\":\""+start_time+"\",\n\"end\":\""+end_time+"\"";
		}
}
