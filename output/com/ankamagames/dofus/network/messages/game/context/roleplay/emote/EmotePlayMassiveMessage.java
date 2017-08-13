package package com.ankamagames.dofus.network.messages.game.context.roleplay.emote;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class EmotePlayMassiveMessage extends EmotePlayAbstractMessage implements INetworkMessage {

    private int protocolId = 5691;
    private boolean _isInitialized = false;
    private Vector.<Number> actorIds = ;
    private FuncTree _actorIdstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5691;
    }

    public EmotePlayMassiveMessage initEmotePlayMassiveMessage(int param1,Number  param2,Vector.<Number>  param3) {
         super.initEmotePlayAbstractMessage(param1,param2);
         this.actorIds = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.actorIds = new Vector.<Number>();
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
         this.serializeAs_EmotePlayMassiveMessage(param1);
    }

    public void serializeAs_EmotePlayMassiveMessage(ICustomDataOutput param1) {
         super.serializeAs_EmotePlayAbstractMessage(param1);
         param1.writeShort(this.actorIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.actorIds.length)
            if(this.actorIds[_loc2_] < -9.007199254740992E15 || this.actorIds[_loc2_] > 9.007199254740992E15)
               throw new Exception("Forbidden value (" + this.actorIds[_loc2_] + ") on element 1 (starting at 1) of actorIds.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_EmotePlayMassiveMessage(param1);
    }

    public void deserializeAs_EmotePlayMassiveMessage(ICustomDataInput param1) {
         * _loc4_ = NaN;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readDouble();
            if(_loc4_ < -9.007199254740992E15 || _loc4_ > 9.007199254740992E15)
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of actorIds.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_EmotePlayMassiveMessage(param1);
    }

    public void deserializeAsyncAs_EmotePlayMassiveMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._actorIdstree = param1.addChild(this._actorIdstreeFunc);
    }

    private void _actorIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._actorIdstree.addChild(this._actorIdsFunc);
            _loc3_++;
    }

    private void _actorIdsFunc(ICustomDataInput param1) {
         Number _loc2_ = param1.readDouble();
         if(_loc2_ < -9.007199254740992E15 || _loc2_ > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of actorIds.");
    }

}