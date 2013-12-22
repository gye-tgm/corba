CC            = /usr/bin/g++
CPPFLAGS      = -g -c
LDFLAGS       = -g
OMNI_HOME     = /usr/local
OMNI_INCLUDES = -I$(OMNI_HOME)/include
OMNI_LIB_DIR  = $(OMNI_HOME)/lib
OMNIIDL       = $(OMNI_HOME)/bin/omniidl
INCLUDES      = $(OMNI_INCLUDES)
LIBS          = -lomniORB4 -lomnithread -lomniDynamic4
OBJECTS       = echoSK.o server.o
TOP 		  = ..
IDL_DIR 	  = $(TOP)/common
IDL_FILE	  = $(IDL_DIR)/echo.idl

all server: $(OBJECTS)
	$(CC) $(LDFLAGS) -o server server.o echoSK.o $(LIBS)

compile-client: client.o echoSK.o
	$(CC) $(LDFLAGS) -o client client.o echoSK.o $(LIBS)

server.o: server.cc
	$(CC) $(CPPFLAGS) server.cc -I.

echoSK.o: echoSK.cc echo.hh
	$(CC) $(CPPFLAGS) echoSK.cc -I.

echoSK.cc: $(IDL_FILE)
	$(OMNIIDL) -bcxx $(IDL_FILE)

client.o: client.cc
	$(CC) $(CPPFLAGS) client.cc -I.

clean clean_all:
	rm -fr *.o
	rm -fr *.hh
	rm -fr *SK.cc
	rm -fr server
	rm -fr client
