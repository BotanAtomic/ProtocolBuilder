package com.ankamagames.dofus.network.messages.game.initialization;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ServerExperienceModificatorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6237;
    private boolean _isInitialized = false;
    private int experiencePercent = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6237;
    }

    public ServerExperienceModificatorMessage initServerExperienceModificatorMessage(int param1) {
         this.experiencePercent = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.experiencePercent = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ServerExperienceModificatorMessage(param1);
    }

    public void serializeAs_ServerExperienceModificatorMessage(ICustomDataOutput param1) {
         if(this.experiencePercent < 0)
         {
            throw new Exception("Forbidden value (" + this.experiencePercent + ") on element experiencePercent.");
         }
         param1.writeVarShort(this.experiencePercent);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ServerExperienceModificatorMessage(param1);
    }

    public void deserializeAs_ServerExperienceModificatorMessage(ICustomDataInput param1) {
         this._experiencePercentFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ServerExperienceModificatorMessage(param1);
    }

    public void deserializeAsyncAs_ServerExperienceModificatorMessage(FuncTree param1) {
         param1.addChild(this._experiencePercentFunc);
    }

    private void _experiencePercentFunc(ICustomDataInput param1) {
         this.experiencePercent = param1.readVarUhShort();
         if(this.experiencePercent < 0)
         {
            throw new Exception("Forbidden value (" + this.experiencePercent + ") on element of ServerExperienceModificatorMessage.experiencePercent.");
         }
    }

}