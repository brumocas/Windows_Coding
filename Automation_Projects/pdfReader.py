import PyPDF2
from gtts import gTTS

# Insert the path to your PDF file
pdf_path = "C:/Users/bruco/OneDrive - Universidade do Porto/Professional Life/University/MEEC/1ºano/1ºSemestre/SCP/ParemeterEstimationOfInductionMotors_SeveralMethods.pdf"
pdf_reader = PyPDF2.PdfReader(open(pdf_path, 'rb'))

full_text = ""

for page_num in range(len(pdf_reader.pages)):
    page = pdf_reader.pages[page_num]
    text = page.extract_text()
    clean_text = text.strip().replace('/n', ' ')
    full_text += clean_text

    # Print the clean text if you want to see it for debugging
    print(clean_text)

# Convert the text to speech using gTTS
tts = gTTS(full_text, lang='en')

mp3_path = pdf_path.rsplit(".")[0]
mp3_path = mp3_path + ".mp3"
# Save the generated speech as an MP3 file
tts.save(mp3_path)
