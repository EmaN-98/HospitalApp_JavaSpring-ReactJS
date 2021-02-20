# HospitalApp-Spring-ReactJS-

  Web app that can have 3 types of users: doctors, caregivers and patients. Doctors can do CRUD operations on caregivers, patients and medication, 
caregivers can view their assigned patients and their medication plans and patients can view their own informations.
  It has also a messaging app that sends to the server the activities of the pacients and their duration throught a RabbitMQ queue so the server can analyse them and
check if there are signs of concern.
  Also, there is a pill dispenser app asociated to the pacient which handles the aspects related to the pacient's medication -when it was taken or if it was not taken on the 
prescribed interval.
