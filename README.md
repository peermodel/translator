# translator 
<h2>About</h2>

The Peer Model is a modeling tool for distribution, concurrency and blackboard-based collaboration and coordination.
This repository contains the translator that converts a use case into Go-code that can be executed by the simulator.

<h2>Installation</h2>

(1) You need a runtime installation for the programming languages Java (https://www.java.com/) and Go-Lang (https://go.dev/). 
   
  Note: The Java and Go-Lang environment variables - especially the path variables - must be set correctly. See  manual of the respective programming language.

(2) Download the most recent jar file of the peermodel-translator from https://github.com/peermodel/translator/releases and store it in a local directory. Let us refer to the absolute path of this local directory with <em>LDIR</em> in the following.

(3) Check out the examples found in https://github.com/peermodel/examples into <em>LDIR</em>.


<h2>Translation of a use case</h2>

(4) Open a powershell and change directory to <em>LDIR</em>, i.e:

  <b>cd </b><em>LDIR</em>

(5) Execute the following command to e.g. translate the ClientServer use case, modeled with DRAWIO, into go-code. The use case may have many configurations, concretely we will compile the configuration termed "One". The use case must be exported as non-compressed xml to <em>LDIR</em>/examples/_USE-CASES/_DRAWIO\Apps:  

  <b>java -jar ./peermodel-translator-2.0.0.jar DRAWIO ./examples/ Apps/ ClientServer One GO-CODE</b>
  
  Note: In <em>LDIR</em>/examples/_GO-AUTOMATON/src/useCases the compiled use case .go-files can be found. The first time you translate a use case, the directory <em>LDIR</em>/examples/_GO-AUTOMATON is created.
  
  Info: The ClientServer example starts two peers termed client1 and superServer. Client1 sends one request to the superServer which in turn sends an answer back. When client1 receives the answer, the system is stopped.

(6) Execute once the following commands (starting in <em>LDIR</em>) in order to create all dependencies for the simulator:

  <b>cd </b><em>LDIR</em><b>/examples/_GO-AUTOMATON/src/useCases</b>
  
  <b>go mod tidy</b>
  
  <b>cd </b><em>LDIR</em>


<strong>Simulation run of a use case</strong>

(7) Now you can run the desired use case. E.g. if you want to run the simulator with the just compiled ClientServer use case, you have to type:

  <b>cd </b><em>LDIR</em><b>/examples/_GO-AUTOMATON/src/useCases/Apps/ClientServer_One/test</b>
  
  <b>go test</b>
  
  Info: The simulator output for the example use case contains:
  - Traces of services called by peers:
   Client1 peer reports that it was started which means that it sent a request to the superServer peer.
   SuperServer peer reports that it was initialized.
   SuperServer peer reports that it replied an answer to client1 peer.
   Client1 reports that it stopped and displays the entry representing the answer from superServer peer
   System service "STOP" was called.
  - SYS INFO traces that inform about STOP of all automata machines, and about some system modi flags.
  - The result space after use case execution, namely that in the output container of the client1 peer (termed "client1-POC, whereby POC stands for peer output container) is one entry that is the answer that client1 received from superServer.
  - Some system statistics about the simulation run.
	
(8) Analogously you may compile and start other use cases.
	
(9) Read the examples readme file (https://github.com/peermodel/examples) for how to model your own use case.

--
