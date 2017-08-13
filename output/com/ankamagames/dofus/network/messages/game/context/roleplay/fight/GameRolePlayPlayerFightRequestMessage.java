package com.ankamagames.dofus.network.messages.game.context.roleplay.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayPlayerFightRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5731;
    private boolean _isInitialized = false;
    private Number targetId = 0;
    private int targetCellId = 0;
    private boolean friendly = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.targetId < 0 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeVarLong(this.targetId);
         if(this.targetCellId < -1 || this.targetCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.targetCellId + ") on element targetCellId.");
         }
         param1.writeShort(this.targetCellId);
         param1.writeBoolean(this.friendly);
    }

    public void deserialize(ICustomDataInput param1) {
         this.targetId = param1.readVarUhLong();
         if(this.targetId < 0 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element of GameRolePlayPlayerFightRequestMessage.targetId.");
         }
         this.targetCellId = param1.readShort();
         if(this.targetCellId < -1 || this.targetCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.targetCellId + ") on element of GameRolePlayPlayerFightRequestMessage.targetCellId.");
         }
         this.friendly = param1.readBoolean();
    }

}