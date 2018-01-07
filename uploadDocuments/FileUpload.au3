WinWaitActive("File Upload")
ControlFocus("File Upload","","Edit1")
ControlSetText("File Upload","","Edit1",$CmdLine[1])
ControlClick("File Upload","","Button1")