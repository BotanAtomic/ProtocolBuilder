package com.ankamagames.dofus.network.messages.game.context.roleplay.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayPlayerFightFriendlyAnsweredMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5733;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private Number sourceId = 0;
    private Number targetId = 0;
    private boolean accept = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.fightId);
         if(this.sourceId < 0 || this.sourceId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sourceId + ") on element sourceId.");
         }
         param1.writeVarLong(this.sourceId);
         if(this.targetId < 0 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeVarLong(this.targetId);
         param1.writeBoolean(this.accept);
    }

    public void deserialize(ICustomDataInput param1) {
         this.fightId = param1.readInt();
         this.sourceId = param1.readVarUhLong();
         if(this.sourceId < 0 || this.sourceId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sourceId + ") on element of GameRolePlayPlayerFightFriendlyAnsweredMessage.sourceId.");
         }
         this.targetId = param1.readVarUhLong();
         if(this.targetId < 0 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element of GameRolePlayPlayerFightFriendlyAnsweredMessage.targetId.");
         }
         this.accept = param1.readBoolean();
    }

}