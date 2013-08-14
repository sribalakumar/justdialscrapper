import re
import urllib2
from BeautifulSoup import BeautifulSoup
import xlwt
import csv



def get_start_url(listing):
    if(listing.endswith('/')):
        if(listing.startswith('w')):
            list="http://"+listing+where.capitalize()+'/'+what.capitalize()
        else:
            list=listing+where.capitalize()+'/'+what.capitalize()
    else:
        list="http://"+listing+'/'+where.capitalize()+'/'+what.capitalize()
    return list

def get_html(url):
    msg=urllib2.urlopen(url).read()
    return msg


if __name__=='__main__':
    listing="www.justdial.com"
    where=raw_input("City: ")
    what=raw_input("Category: ")
    url=get_start_url(listing)
   
    name=[]
    person=[]
    phone=[]
    add=[]
    verified=[]

with open(where+'-'+what+'.csv', 'wb') as csvfile:
    spamwriter = csv.writer(csvfile, delimiter=' ',quotechar='|', quoting=csv.QUOTE_MINIMAL)
    spamwriter.writerow(['NAME','PHONE','ADDRESS','VERIFIED'])
    while url:
    #for num in range (0,1):
        if ' ' in url:
            url=url.replace(' ','%20') 
        msg=get_html(url)
        soup=BeautifulSoup(msg)
        print 'Parsing page: '+url
       
        #print 'check'
        #print soup.find('div',{'id':'srchpagination'})('span')[1].text
        #print soup.find('div',{'id':'srchpagination'})('a')[1]['href']
        condition = soup.find('div',{'id':'srchpagination'})('span')[1].text
        nextpage=soup.find('div',{'id':'srchpagination'})('a')[1]['href'].split('page')
        
                         
        nextpage[0]=nextpage[0]+'page-'+ str(int(condition)+1)
        
        for i in soup.findAll('section', {'class': 'jbbg'}):
            
            name.append(i('a')[1]['title'])
            if i('a')[0]['class']== 'jdr':
               verified.append('true')
            else:
               verified.append('false')
        print "for verified case name and flag"
        print len(name)   
        print len(verified)

        for i in soup.findAll('section', {'class': 'jrcl2'}):
            phone.append(i('p')[1]('a')[0].text)
            add.append(i('p')[0].text.replace("View Map",""))
        print "for verified case phone and address"
        print len(phone)
        print len(add)
        
        
        
        for i in soup.findAll('section', {'class': 'jgbg'}):
            name.append(i('a')[0]['title'])
            flag=''
            if i('span')[0]['class']== 'jcn':
               verified.append('false')
               flag='false'
            else:
               flag='true'
            #print i('a')[0]['title']
            #print flag  
        print "for non verified case name and flag"
        print len(name)
        print len(verified)              

        for i in soup.findAll('section', {'class': 'jrcl3'}):
            try:
                phone.append(i('p')[1]('a')[0].text)
                add.append(i('p')[0].text.replace("View Map",""))
            except Exception:
                print Exception
        print "for non verified case phone and add"
        print len(phone)
        print len(add)
  
        url=nextpage[0]
        if(int(condition)==5):
            break;
        
    for i in range(0,len(name)):
        #print name[i]
        print i
        #print phone[i]
        #print add[i]
        #print verified[i]

        try:
            spamwriter.writerow([str(name[i]),str(phone[i]),str(add[i]),str(verified[i])])
        except Exception:
            print Exception
       

    
truecount=0
falsecount=0
with open(where+'-'+what+'.csv', 'rb') as csvfile:
    spamreader = csv.reader(csvfile, delimiter=' ', quotechar='|')
    for row in spamreader:
        #print row[3]
        if row[3]=='true':
            truecount=truecount+1
        if row[3]=='false':
            falsecount=falsecount+1
        #print ', '.join(row)
    print 'truecount is '+str(truecount)
    print 'falsecount is '+str(falsecount)
    print 'total is ' + str(truecount+falsecount)

json="[{'label': '"+"Verified"+"', 'value': "+str(truecount)+"}, {'label': '"+"Not verified"+"', 'value': "+str(falsecount)+"}]"

filename= where+'-'+what+'.json'
writer = open(filename,'w')
writer.write(json)
writer.flush()
        

