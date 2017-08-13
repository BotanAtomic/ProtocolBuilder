package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class SetUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5503;
    private boolean _isInitialized = false;
    private int setId = 0;
    private Vector<uint> setObjects;
    private Vector<ObjectEffect> setEffects;
    private FuncTree _setObjectstree;
    private FuncTree _setEffectstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5503;
    }

    public SetUpdateMessage initSetUpdateMessage(int param1,Vector<uint>  param2,Vector<ObjectEffect>  param3) {
         this.setId = param1;
         this.setObjects = param2;
         this.setEffects = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.setId = 0;
         this.setObjects = new Vector.<uint>();
         this.setEffects = new Vector.<ObjectEffect>();
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
         this.serializeAs_SetUpdateMessage(param1);
    }

    public void serializeAs_SetUpdateMessage(ICustomDataOutput param1) {
         if(this.setId < 0)
         {
            throw new Exception("Forbidden value (" + this.setId + ") on element setId.");
         }
         param1.writeVarShort(this.setId);
         param1.writeShort(this.setObjects.length);
         int _loc2_ = 0;
         while(_loc2_ < this.setObjects.length)
         {
            if(this.setObjects[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.setObjects[_loc2_] + ") on element 2 (starting at 1) of setObjects.");
            }
            param1.writeVarShort(this.setObjects[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.setEffects.length);
         int _loc3_ = 0;
         while(_loc3_ < this.setEffects.length)
         {
            param1.writeShort((this.setEffects[_loc3_] as ObjectEffect).getTypeId());
            (this.setEffects[_loc3_] as ObjectEffect).serialize(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SetUpdateMessage(param1);
    }

    public void deserializeAs_SetUpdateMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         int _loc7_ = 0;
         ObjectEffect _loc8_ = null;
         this._setIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readVarUhShort();
            if(_loc6_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of setObjects.");
            }
            this.setObjects.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readUnsignedShort();
            _loc8_ = ProtocolTypeManager.getInstance(ObjectEffect,_loc7_);
            _loc8_.deserialize(param1);
            this.setEffects.push(_loc8_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SetUpdateMessage(param1);
    }

    public void deserializeAsyncAs_SetUpdateMessage(FuncTree param1) {
         param1.addChild(this._setIdFunc);
         this._setObjectstree = param1.addChild(this._setObjectstreeFunc);
         this._setEffectstree = param1.addChild(this._setEffectstreeFunc);
    }

    private void _setIdFunc(ICustomDataInput param1) {
         this.setId = param1.readVarUhShort();
         if(this.setId < 0)
         {
            throw new Exception("Forbidden value (" + this.setId + ") on element of SetUpdateMessage.setId.");
         }
    }

    private void _setObjectstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._setObjectstree.addChild(this._setObjectsFunc);
            _loc3_++;
         }
    }

    private void _setObjectsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of setObjects.");
         }
         this.setObjects.push(_loc2_);
    }

    private void _setEffectstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._setEffectstree.addChild(this._setEffectsFunc);
            _loc3_++;
         }
    }

    private void _setEffectsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         ObjectEffect _loc3_ = ProtocolTypeManager.getInstance(ObjectEffect,_loc2_);
         _loc3_.deserialize(param1);
         this.setEffects.push(_loc3_);
    }

}