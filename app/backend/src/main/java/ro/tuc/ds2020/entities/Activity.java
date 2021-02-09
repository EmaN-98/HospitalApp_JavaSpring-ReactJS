package ro.tuc.ds2020.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Activity {
		@JsonProperty("patient_id")
		private String patient_id;
		@JsonProperty("activity")
		private String activity;
		@JsonProperty("start")
		private String start;
		@JsonProperty("end")
		private String end;
		

		public Activity() {
			super();
		}

		public Activity(String patient_id, String activity, String start, String end) {
			super();
			this.patient_id = patient_id;
			this.activity = activity;
			this.start = start;
			this.end = end;
		}

		public String getPatient_id() {
			return patient_id;
		}

		public void setPatient_id(String patient_id) {
			this.patient_id = patient_id;
		}

		public String getActivity() {
			return activity;
		}

		public void setActivity(String activity) {
			this.activity = activity;
		}

		public String getStart() {
			return start;
		}

		public void setStart(String start) {
			this.start = start;
		}

		public String getEnd() {
			return end;
		}

		public void setEnd(String end) {
			this.end = end;
		}

		@Override
		public String toString() {
			return "\"patient_id\":\""+"\",\n"+patient_id+"\"activity\":\""+activity+"\",\n"+"\"start\":\""+start+"\",\n\"end\":\""+end+"\"";
		}
}
