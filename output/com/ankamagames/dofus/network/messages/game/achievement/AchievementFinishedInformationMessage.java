package com.ankamagames.dofus.network.messages.game.achievement;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AchievementFinishedInformationMessage extends AchievementFinishedMessage implements INetworkMessage {

    private int protocolId = 6381;
    private boolean _isInitialized = false;
    private String name = "";
    private Number playerId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeVarShort(this.id);
         if(this.finishedlevel < 0 || this.finishedlevel > 206)
         {
            throw new Exception("Forbidden value (" + this.finishedlevel + ") on element finishedlevel.");
         }
         param1.writeByte(this.finishedlevel);
         param1.writeUTF(this.name);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AchievementFinishedMessage(param1);
         this.name = param1.readUTF();
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of AchievementFinishedInformationMessage.playerId.");
         }
    }

}