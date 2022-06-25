setup()
  clear()   
  dasies = new dasiy()
  turtle.shape="flower"
  turtle.name=dasies;
  max-age=25
  global-temperature=0
  if scenario = "ramp-up-ramp-down" 
     solar-luminosity =0.8 
  if scenario = "low solar luminosity"  
     solar-luminosity =0.6 
  if scenario = "our solar luminosity"  
     solar-luminosity =1.0 
  if scenario = "high solar luminosity" 
     solar-luminosity =1.4 
  seed-blacks-randomly()
  seed-whites-randomly()
  for each dasies : dasie
     dasie.age=math.random(0,max-age)
  calc-temperature(patches)
  gobal-temp=mean(patches)
  update-display()
  reset-ticks()


go()
  
  calc-temperature(patches)
  diffuse(temperateure=.5)
  check-survivability(dasies)
  gobal-temp=mean(patches)
  update-display()
  tick()
  if scenario = "ramp-up-ramp-down"
     if ticks > 200 and ticks <= 400
        solar-luminosity= (solar-luminosity + 0.005)
     if ticks > 600 and ticks <= 850
        solar-luminosity = solar-luminosity - 0.0025
  if scenario = "low solar luminosity" 
     solar-luminosity 0.6
  if scenario = "our solar luminosity" 
   set solar-luminosity =1.0 
  if scenario = "high solar luminosity" 
   set solar-luminosity= 1.4 




check-survivability ;; turtle procedure
  seed-threshold =0
  not-empty-spaces= nil
  seeding-place= nil

  age =(age + 1)
  if age < max-age  
     seed-threshold= ((0.1457 * temperature) - (0.0032 * (temperature ^ 2)) - 0.6443)
     if random-float 1.0 < seed-threshold 
       seeding-place=one-of neighbors with [not any? daisies-here]

       if seeding-place != nobody       
         if color == white         
            seeding-place =[sprout-daisies 1 [set-as-white]  ]
         
         if color == black          
            seeding-place= [sprout-daisies 1 [set-as-black]  ]         
  else
    die()


to calc-temperature  
   absorbed-luminosity =0
   local-heating =0
  if not any? daisies-here    
     absorbed-luminosity =((1 - albedo-of-surface) * solar-luminosity)
  else
    dasies[]=getrandomdaises(this)  
    absorbed-luminosity ((1 - albedo) * solar-luminosity)
  if absorbed-luminosity > 0
      local-heating =72 * ln absorbed-luminosity + 80
  else
      local-heating =80
  temperature= ((temperature + local-heating) / 2)







