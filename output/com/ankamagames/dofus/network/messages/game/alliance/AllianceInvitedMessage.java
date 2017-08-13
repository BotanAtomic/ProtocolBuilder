package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicNamedAllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AllianceInvitedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6397;
    private boolean _isInitialized = false;
    private Number recruterId = 0;
    private String recruterName = "";
    private BasicNamedAllianceInformations allianceInfo;
    private FuncTree _allianceInfotree;


    public void serialize(ICustomDataOutput param1) {
         if(this.recruterId < 0 || this.recruterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.recruterId + ") on element recruterId.");
         }
         param1.writeVarLong(this.recruterId);
         param1.writeUTF(this.recruterName);
         this.allianceInfo.serializeAs_BasicNamedAllianceInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.recruterId = param1.readVarUhLong();
         if(this.recruterId < 0 || this.recruterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.recruterId + ") on element of AllianceInvitedMessage.recruterId.");
         }
         this.recruterName = param1.readUTF();
         this.allianceInfo = new BasicNamedAllianceInformations();
         this.allianceInfo.deserialize(param1);
    }

}