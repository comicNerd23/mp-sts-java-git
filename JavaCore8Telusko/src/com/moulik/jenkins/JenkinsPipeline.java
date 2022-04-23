package com.moulik.jenkins;

/**
 * How to create Jenkins Pipeline with an Example | Pipeline as Code | Tech Primers
 * 
 * A Jenkins Pipeline is like a plugin inside Jenkins. A pipeline is similar to a Jenkins job but you can control it using
 * jenkins file. In a pipeline, we define an agent, stages.
 * 
 * You need to create a file inside your codebase called 'Jenkinsfile' that will act as a pipeline. This is Groovy DSL.
 * 
 *  pipeline {
 *  	agent any
 *  
 *  	stages {
 *  		stage ('Compile Stage') {
 *  			steps {
 *  				withMaven(maven : 'maven_3_5_0') {			This name must be setup in maven plugin.
 *  					sh 'mvn clean compile'
 *  				}
 *  			}
 *  		}
 *  
 *  		stage ('Testing Stage') {
 *  			steps {
 *  				withMaven(maven : 'maven_3_5_0') {			
 *  					sh 'mvn test'
 *  				}
 *  			}
 *  		}
 *  
 *  		stage ('Deployment Stage') {
 *  			steps {
 *  				withMaven(maven : 'maven_3_5_0') {			
 *  					sh 'mvn deploy'
 *  				}
 *  			}
 *  		}
 *  		
 *  	}
 *  }
 *  
 *  Commit this code to Github and then you need to create a pipeline in Jenkins. Here you will give your Git repo etc.
 *  The advantage of pipeline is that you can see how much time each stage took and if it fails, in which phase it failed.
 *
 */
public class JenkinsPipeline {

}
