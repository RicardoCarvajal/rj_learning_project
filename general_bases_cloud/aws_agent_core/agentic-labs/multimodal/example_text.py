"""Text message examples"""

from strands import Agent

print("PROMPT AS STRING")
agent1 = Agent()
agent1("What are the first three colors of the rainbow?")

print("PROMPT AS LIST OF CONTENT BLOCKS")
agent2 = Agent()
agent2(
    [
        {"text": "What are the first three colors of the rainbow?"}
    ]
)
