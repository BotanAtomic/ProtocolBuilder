package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildInvitationStateRecruterMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5563;
    private boolean _isInitialized = false;
    private String recrutedName = "";
    private int invitationState = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.recrutedName);
         param1.writeByte(this.invitationState);
    }

    public void deserialize(ICustomDataInput param1) {
         this.recrutedName = param1.readUTF();
         this.invitationState = param1.readByte();
         if(this.invitationState < 0)
         {
            throw new Exception("Forbidden value (" + this.invitationState + ") on element of GuildInvitationStateRecruterMessage.invitationState.");
         }
    }

}