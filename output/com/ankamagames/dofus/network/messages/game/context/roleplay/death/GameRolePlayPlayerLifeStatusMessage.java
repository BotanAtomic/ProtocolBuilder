package package com.ankamagames.dofus.network.messages.game.context.roleplay.death;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameRolePlayPlayerLifeStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5996;
    private boolean _isInitialized = false;
    private int state = 0;
    private int phenixMapId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5996;
    }

    public GameRolePlayPlayerLifeStatusMessage initGameRolePlayPlayerLifeStatusMessage(int param1,int  param2) {
         this.state = param1;
         this.phenixMapId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.state = 0;
         this.phenixMapId = 0;
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
         this.serializeAs_GameRolePlayPlayerLifeStatusMessage(param1);
    }

    public void serializeAs_GameRolePlayPlayerLifeStatusMessage(ICustomDataOutput param1) {
         param1.writeByte(this.state);
         if(this.phenixMapId < 0)
            throw new Exception("Forbidden value (" + this.phenixMapId + ") on element phenixMapId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayPlayerLifeStatusMessage(param1);
    }

    public void deserializeAs_GameRolePlayPlayerLifeStatusMessage(ICustomDataInput param1) {
         this._stateFunc(param1);
         this._phenixMapIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayPlayerLifeStatusMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayPlayerLifeStatusMessage(FuncTree param1) {
         param1.addChild(this._stateFunc);
         param1.addChild(this._phenixMapIdFunc);
    }

    private void _stateFunc(ICustomDataInput param1) {
         this.state = param1.readByte();
         if(this.state < 0)
            throw new Exception("Forbidden value (" + this.state + ") on element of GameRolePlayPlayerLifeStatusMessage.state.");
    }

    private void _phenixMapIdFunc(ICustomDataInput param1) {
         this.phenixMapId = param1.readInt();
         if(this.phenixMapId < 0)
            throw new Exception("Forbidden value (" + this.phenixMapId + ") on element of GameRolePlayPlayerLifeStatusMessage.phenixMapId.");
    }

}