# Panel
Application for parsing text information (in txt,rtf, doc formats), define if politics persons are in the text. Export data in xls format

# Install
Use build.xml for Ant or download exe by link http://www.ex.ua/321199179763 , also by this link you can download materials for testing program.

# Project structure
<p align="center">
  <img src="https://raw.githubusercontent.com/Pragmatique/Panel/NewBranch/materials/Panel.png" width="550"/>
</p>

# Code structure & UML
Main tasks of Model:

1. **Get text from files.** Classes TxtFilesAsText, RtfFilesAsText, DocFilesAsText are inhereded from abstract class FilesAsText, but use different technologies to get text (txt - java.io; rtf - swing.text.rtf; doc - apache.poi). In code used Factory design pattern, and the method .buildText of the class FilesFactory returns the text of all txt/rtf/doc file types. (Supported file types are fixed with enum SupportedFileTypes).
2. **Get persons from text.** The Class TVParser (and RadioParser/DetailedTVParser that inhereted from TVParser) split text on plots, definit start/end time of a plot, it's name and full text. The Class PersonsChecker has static method checkFactory (used Design Pattern - Factory method), that TVParser use for marking if the political person is present in a plot.
3. **Merging files with the same type.** The Class FileMerger merge files with help of fabrique class FilesFactory, that returns information of all files in chosen directory. Only one exception of this rule - merging excel file: method excelMerger() don't use class FilesFactory due to cell date structure of xls files.

<p align="center">
  <img src="https://raw.githubusercontent.com/Pragmatique/Panel/NewBranch/materials/irisPanel.png" width="550"/>
</p>

# Screenshots
<p align="center">
  <img src="https://raw.githubusercontent.com/Pragmatique/Panel/NewBranch/materials/Panel1.jpg" width="550"/>
</p>
<p align="center">
  <img src="https://raw.githubusercontent.com/Pragmatique/Panel/NewBranch/materials/PanelException.jpg" width="550"/>
</p>
<p align="center">
  <img src="https://raw.githubusercontent.com/Pragmatique/Panel/NewBranch/materials/PanelDone.jpg" width="550"/>
</p>
<p align="center">
  <img src="https://raw.githubusercontent.com/Pragmatique/Panel/NewBranch/materials/Excel.jpg" width="550"/>
</p>
<p align="center">
  <img src="https://raw.githubusercontent.com/Pragmatique/Panel/NewBranch/materials/MergedFile.jpg" width="550"/>
</p>
