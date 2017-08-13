package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag.meeting;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class HavenBagPermissionsUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6713;
    private boolean _isInitialized = false;
    private int permissions = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6713;
    }

    public HavenBagPermissionsUpdateMessage initHavenBagPermissionsUpdateMessage(int param1) {
         this.permissions = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.permissions = 0;
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
         this.serializeAs_HavenBagPermissionsUpdateMessage(param1);
    }

    public void serializeAs_HavenBagPermissionsUpdateMessage(ICustomDataOutput param1) {
         if(this.permissions < 0)
         {
            throw new Exception("Forbidden value (" + this.permissions + ") on element permissions.");
         }
         param1.writeInt(this.permissions);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HavenBagPermissionsUpdateMessage(param1);
    }

    public void deserializeAs_HavenBagPermissionsUpdateMessage(ICustomDataInput param1) {
         this._permissionsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HavenBagPermissionsUpdateMessage(param1);
    }

    public void deserializeAsyncAs_HavenBagPermissionsUpdateMessage(FuncTree param1) {
         param1.addChild(this._permissionsFunc);
    }

    private void _permissionsFunc(ICustomDataInput param1) {
         this.permissions = param1.readInt();
         if(this.permissions < 0)
         {
            throw new Exception("Forbidden value (" + this.permissions + ") on element of HavenBagPermissionsUpdateMessage.permissions.");
         }
    }

}