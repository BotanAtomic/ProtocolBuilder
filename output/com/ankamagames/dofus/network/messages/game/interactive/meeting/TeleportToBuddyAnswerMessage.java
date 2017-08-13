package com.ankamagames.dofus.network.messages.game.interactive.meeting;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TeleportToBuddyAnswerMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6293;
    private boolean _isInitialized = false;
    private int dungeonId = 0;
    private Number buddyId = 0;
    private boolean accept = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
         }
         param1.writeVarShort(this.dungeonId);
         if(this.buddyId < 0 || this.buddyId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.buddyId + ") on element buddyId.");
         }
         param1.writeVarLong(this.buddyId);
         param1.writeBoolean(this.accept);
    }

    public void deserialize(ICustomDataInput param1) {
         this.dungeonId = param1.readVarUhShort();
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element of TeleportToBuddyAnswerMessage.dungeonId.");
         }
         this.buddyId = param1.readVarUhLong();
         if(this.buddyId < 0 || this.buddyId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.buddyId + ") on element of TeleportToBuddyAnswerMessage.buddyId.");
         }
         this.accept = param1.readBoolean();
    }

}