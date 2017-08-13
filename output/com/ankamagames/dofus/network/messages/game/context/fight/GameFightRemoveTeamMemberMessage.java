package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightRemoveTeamMemberMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 711;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private int teamId = 2;
    private Number charId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
         }
         param1.writeShort(this.fightId);
         param1.writeByte(this.teamId);
         if(this.charId < -9.007199254740992E15 || this.charId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.charId + ") on element charId.");
         }
         param1.writeDouble(this.charId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.fightId = param1.readShort();
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element of GameFightRemoveTeamMemberMessage.fightId.");
         }
         this.teamId = param1.readByte();
         if(this.teamId < 0)
         {
            throw new Exception("Forbidden value (" + this.teamId + ") on element of GameFightRemoveTeamMemberMessage.teamId.");
         }
         this.charId = param1.readDouble();
         if(this.charId < -9.007199254740992E15 || this.charId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.charId + ") on element of GameFightRemoveTeamMemberMessage.charId.");
         }
    }

}