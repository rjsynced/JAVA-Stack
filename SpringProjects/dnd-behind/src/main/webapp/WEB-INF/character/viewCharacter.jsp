<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Character</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
	<div class="container">
		<div class="d-flex align-items-center justify-content-between">
			<h1><c:out value="${character.name}"/></h1>
			<a href="/campaigns">Back to Home</a>
		</div>
		<h3>Level: <c:out value="${character.level}"/> <span>&bull;</span> <span><c:out value="${oneRace.name}"/>-</span><c:out value="${oneJob.name}"/></h3>
		<div class="row">
	    <div class="col">
		<h4 class="text-center">Ability Scores</h4>
			<div class="d-flex justify-content-between">
				<div class="p-2 text-center outline">
					<p><c:out value="${character.strength}"/>
						<c:if test="${character.strength == 20}">
							(+5)
						</c:if>
						<c:if test="${character.strength >= 18 && character.strength < 20}">
							(+4)
						</c:if>
						<c:if test="${character.strength >= 16 && character.strength < 18}">
							(+3)
						</c:if>
						<c:if test="${character.strength >= 14 && character.strength < 16}">
							(+2)
						</c:if>
						<c:if test="${character.strength >= 12 && character.strength < 14}">
							(+1)
						</c:if>
						<c:if test="${character.strength == 10 || character.strength == 11}">
							(+0)
						</c:if>
						<c:if test="${character.strength >= 8 && character.strength < 10}">
							(-1)
						</c:if>
						<c:if test="${character.strength >= 6 && character.strength < 8}">
							(-2)
						</c:if>
						<c:if test="${character.strength >= 4 && character.strength < 6}">
							(-3)
						</c:if>
						<c:if test="${character.strength >= 2 && character.strength < 4 }">
							(-4)
						</c:if>
						<c:if test="${character.strength <= 1}">
							(-5)
						</c:if>
					</p>
					<button class="roll-button" id="button">STR</button>
				</div>
				<div class="p-2 text-center outline">
					<p><c:out value="${character.constitution}"/>
						<c:if test="${character.constitution == 20}">
							(+5)
						</c:if>
						<c:if test="${character.constitution >= 18 && character.constitution < 20}">
							(+4)
						</c:if>
						<c:if test="${character.constitution >= 16 && character.constitution < 18}">
							(+3)
						</c:if>
						<c:if test="${character.constitution >= 14 && character.constitution < 16}">
							(+2)
						</c:if>
						<c:if test="${character.constitution >= 12 && character.constitution < 14}">
							(+1)
						</c:if>
						<c:if test="${character.constitution == 10 || character.constitution == 11}">
							(+0)
						</c:if>
						<c:if test="${character.constitution >= 8 && character.constitution < 10}">
							(-1)
						</c:if>
						<c:if test="${character.constitution >= 6 && character.constitution < 8}">
							(-2)
						</c:if>
						<c:if test="${character.constitution >= 4 && character.constitution < 6}">
							(-3)
						</c:if>
						<c:if test="${character.constitution >= 2 && character.constitution < 4 }">
							(-4)
						</c:if>
						<c:if test="${character.constitution <= 1}">
							(-5)
						</c:if>
					</p>
					<button class="roll-button" id="button1">CON</button>
				</div>
				<div class="p-2 text-center outline">
					<p><c:out value="${character.dexterity}"/>
						<c:if test="${character.dexterity == 20}">
							(+5)
						</c:if>
						<c:if test="${character.dexterity >= 18 && character.dexterity < 20}">
							(+4)
						</c:if>
						<c:if test="${character.dexterity >= 16 && character.dexterity < 18}">
							(+3)
						</c:if>
						<c:if test="${character.dexterity >= 14 && character.dexterity < 16}">
							(+2)
						</c:if>
						<c:if test="${character.dexterity >= 12 && character.dexterity < 14}">
							(+1)
						</c:if>
						<c:if test="${character.dexterity == 10 || character.dexterity == 11}">
							(+0)
						</c:if>
						<c:if test="${character.dexterity >= 8 && character.dexterity < 10}">
							(-1)
						</c:if>
						<c:if test="${character.dexterity >= 6 && character.dexterity < 8}">
							(-2)
						</c:if>
						<c:if test="${character.dexterity >= 4 && character.dexterity < 6}">
							(-3)
						</c:if>
						<c:if test="${character.dexterity >= 2 && character.dexterity < 4 }">
							(-4)
						</c:if>
						<c:if test="${character.dexterity <= 1}">
							(-5)
						</c:if>
					</p>
					<button class="roll-button" id="button2">DEX</button>
				</div>
				<div class="p-2 text-center outline">
					<p><c:out value="${character.intelligence}"/>
						<c:if test="${character.intelligence == 20}">
							(+5)
						</c:if>
						<c:if test="${character.intelligence >= 18 && character.intelligence < 20}">
							(+4)
						</c:if>
						<c:if test="${character.intelligence >= 16 && character.intelligence < 18}">
							(+3)
						</c:if>
						<c:if test="${character.intelligence >= 14 && character.intelligence < 16}">
							(+2)
						</c:if>
						<c:if test="${character.intelligence >= 12 && character.intelligence < 14}">
							(+1)
						</c:if>
						<c:if test="${character.intelligence == 10 || character.intelligence == 11}">
							(+0)
						</c:if>
						<c:if test="${character.intelligence >= 8 && character.intelligence < 10}">
							(-1)
						</c:if>
						<c:if test="${character.intelligence >= 6 && character.intelligence < 8}">
							(-2)
						</c:if>
						<c:if test="${character.intelligence >= 4 && character.intelligence < 6}">
							(-3)
						</c:if>
						<c:if test="${character.intelligence >= 2 && character.intelligence < 4 }">
							(-4)
						</c:if>
						<c:if test="${character.intelligence <= 1}">
							(-5)
						</c:if>
					</p>
					<button class="roll-button" id="button3">INT</button>
				</div>
				<div class="p-2 text-center outline">
					<p><c:out value="${character.wisdom}"/>
						<c:if test="${character.wisdom == 20}">
							(+5)
						</c:if>
						<c:if test="${character.wisdom >= 18 && character.wisdom < 20}">
							(+4)
						</c:if>
						<c:if test="${character.wisdom >= 16 && character.wisdom < 18}">
							(+3)
						</c:if>
						<c:if test="${character.wisdom >= 14 && character.wisdom < 16}">
							(+2)
						</c:if>
						<c:if test="${character.wisdom >= 12 && character.wisdom < 14}">
							(+1)
						</c:if>
						<c:if test="${character.wisdom == 10 || character.wisdom == 11}">
							(+0)
						</c:if>
						<c:if test="${character.wisdom >= 8 && character.wisdom < 10}">
							(-1)
						</c:if>
						<c:if test="${character.wisdom >= 6 && character.wisdom < 8}">
							(-2)
						</c:if>
						<c:if test="${character.wisdom >= 4 && character.wisdom < 6}">
							(-3)
						</c:if>
						<c:if test="${character.wisdom >= 2 && character.wisdom < 4 }">
							(-4)
						</c:if>
						<c:if test="${character.wisdom <= 1}">
							(-5)
						</c:if>
					</p>
					<button class="roll-button" id="button4">WIS</button>
				</div>
				<div class="p-2 text-center outline">
					<p><c:out value="${character.charisma}"/>
						<c:if test="${character.charisma == 20}">
							(+5)
						</c:if>
						<c:if test="${character.charisma >= 18 && character.charisma < 20}">
							(+4)
						</c:if>
						<c:if test="${character.charisma >= 16 && character.charisma < 18}">
							(+3)
						</c:if>
						<c:if test="${character.charisma >= 14 && character.charisma < 16}">
							(+2)
						</c:if>
						<c:if test="${character.charisma >= 12 && character.charisma < 14}">
							(+1)
						</c:if>
						<c:if test="${character.charisma == 10 || character.charisma == 11}">
							(+0)
						</c:if>
						<c:if test="${character.charisma >= 8 && character.charisma < 10}">
							(-1)
						</c:if>
						<c:if test="${character.charisma >= 6 && character.charisma < 8}">
							(-2)
						</c:if>
						<c:if test="${character.charisma >= 4 && character.charisma < 6}">
							(-3)
						</c:if>
						<c:if test="${character.charisma >= 2 && character.charisma < 4 }">
							(-4)
						</c:if>
						<c:if test="${character.charisma <= 1}">
							(-5)
						</c:if>
					</p>
					<button class="roll-button" id="button5">CHA</button>
				</div>
			</div>
		      <h4 class="text-center mt-4">Skills</h4>
		      <div class="row">
		      	<div class="col">
		      		<div>
						<input type="checkbox" name="isAcrobatics" value="acrobatics">
						<label>Acrobatics</label>
					</div>
					<div>
						<input type="checkbox" name="isAnimalHandling" value="acrobatics">
						<label>Animal-Handling</label>
					</div>
					<div>
						<input type="checkbox" name="isArcana" value="acrobatics">
						<label>Arcana</label>
					</div>
					<div>
						<input type="checkbox" name="isAthletics" value="athletics">
						<label>Athletics</label>
					</div>
					<div>
						<input type="checkbox" name="isDeception" value="deception">
						<label>Deception</label>
					</div>
					<div>
						<input type="checkbox" name="isHistory" value="history">
						<label>History</label>
					</div>
					<div>
						<input type="checkbox" name="isInsight" value="insight">
						<label>Insight</label>
					</div>
					<div>
						<input type="checkbox" name="isIntimidation" value="intimidation">
						<label>Intimidation</label>
					</div>
					<div>
						<input type="checkbox" name="isStealth" value="stealth">
						<label>Stealth</label>
					</div>
		      	</div>
		      	<div class="col">
		      		<div>
						<input type="checkbox" name="isInvestigation" value="investigation">
						<label>Investigation</label>
					</div>
					<div>
						<input type="checkbox" name="isMedicine" value="medicine">
						<label>Medicine</label>
					</div>
					<div>
						<input type="checkbox" name="isNature" value="nature">
						<label>Nature</label>
					</div>
					<div>
						<input type="checkbox" name="isPerception" value="perception">
						<label>Perception</label>
					</div>
					<div>
						<input type="checkbox" name="isPerformance" value="performance">
						<label>Performance</label>
					</div>
					<div>
						<input type="checkbox" name="isPersuasion" value="persuasion">
						<label>Persuasion</label>
					</div>
					<div>
						<input type="checkbox" name="isReligion" value="religion">
						<label>Religion</label>
					</div>
					<div>
						<input type="checkbox" name="isSlightOfHand" value="slightOfHand">
						<label>Slight-of-Hand</label>
					</div>
					<div>
						<input type="checkbox" name="isSurvival" value="survival">
						<label>Survival</label>
					</div>
		      	</div>
		      	<div>
					<h4 class="text-center mt-4">Traits</h4>
					<p><c:out value="${oneRace.abilityBonus}"/></p>
					<p><c:out value="${oneRace.age}"/></p>
					<p><c:out value="${oneRace.size}"/></p>
				</div>
				<div>
					<h4 class="text-center mt-4">Class Summary</h4>
					<p><c:out value="${oneJob.description}"/></p>
					
				</div>
		      </div>
		    </div>
		    <div class="col">
		    		<h4 class="text-center">Dice Rolls</h4>
		    	<div class="row">
		    		<div class="col">
			    		<div class="card outline">
			    			<span class="underline">Strength rolls</span><span id="str"></span>
			    		</div>
			    		<div class="card outline">
			    			<span class="underline">Constitution rolls</span><span id="con"></span>
			    		</div>
			    		<div class="card outline">
			    			<span class="underline">Dexterity rolls</span><span id="dex"></span>
			    		</div>
		    		</div>
		    		<div class="col">
			    		<div class="card outline">
			    			<span class="underline">Intelligence rolls</span><span id="int"></span>
			    		</div>
			    		<div class="card outline">
			    			<span class="underline">Wisdom rolls</span><span id="wis"></span>
			    		</div>
			    		<div class="card outline">
			    			<span class="underline">Charisma rolls</span><span id="cha"></span>
			    		</div>
		    		</div>
		    	</div>
		    	<h4 class="text-center mt-4">Proficiencies & Languages</h4>
		      <div>
		      	<span class="underline">Skill Proficiencies</span>
		      	<p><c:out value="${oneJob.skillProf}"/></p>
		      </div>
		      <div>
		      	<span class="underline">Armor & Weapons</span>
		      	<p><c:out value="${oneJob.armorAndWeapons}"/></p>
		      </div>
		      <div>
		      	<span class="underline">Languages</span>
		      	<p><c:out value="${oneRace.languages}"/></p>
		      </div>
			    <div>
			    	<h4 class="text-center mt-4">Abilities</h4>
			    	<div>
				      	<span class="underline">Racial Ability</span>
				      	<p><c:out value="${oneRace.abilities}"/></p>
				    </div>
				    <div>
				      	<span class="underline">Racial Traits</span>
				      	<p><c:out value="${oneRace.traits}"/></p>
				    </div>
			    </div>
		    </div>
		 </div>
	</div>
	<script type="text/javascript" src="/js/custom.js"></script>
</body>
</html>