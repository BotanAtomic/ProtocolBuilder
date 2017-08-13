package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameActionFightSpellCastMessage extends AbstractGameActionFightTargetedAbilityMessage implements INetworkMessage {

    private int protocolId = 1010;
    private boolean _isInitialized = false;
    private int spellId = 0;
    private int spellLevel = 0;
    private Vector<int> portalsIds;
    private FuncTree _portalsIdstree;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 1010;
    }

    public GameActionFightSpellCastMessage initGameActionFightSpellCastMessage(int param1,Number  param2,Number  param3,int  param4,int  param5,boolean  param6,boolean  param7,int  param8,int  param9,Vector<int>  param10) {
         super.initAbstractGameActionFightTargetedAbilityMessage(param1,param2,param3,param4,param5,param6,param7);
         this.spellId = param8;
         this.spellLevel = param9;
         this.portalsIds = param10;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.spellId = 0;
         this.spellLevel = 0;
         this.portalsIds = new Vector.<int>();
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
         this.serializeAs_GameActionFightSpellCastMessage(param1);
    }

    public void serializeAs_GameActionFightSpellCastMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractGameActionFightTargetedAbilityMessage(param1);
         if(this.spellId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellId + ") on element spellId.");
         }
         param1.writeVarShort(this.spellId);
         if(this.spellLevel < 1 || this.spellLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.spellLevel + ") on element spellLevel.");
         }
         param1.writeShort(this.spellLevel);
         param1.writeShort(this.portalsIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.portalsIds.length)
         {
            param1.writeShort(this.portalsIds[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameActionFightSpellCastMessage(param1);
    }

    public void deserializeAs_GameActionFightSpellCastMessage(ICustomDataInput param1) {
         * _loc4_ = 0;
         super.deserialize(param1);
         this._spellIdFunc(param1);
         this._spellLevelFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readShort();
            this.portalsIds.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameActionFightSpellCastMessage(param1);
    }

    public void deserializeAsyncAs_GameActionFightSpellCastMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._spellIdFunc);
         param1.addChild(this._spellLevelFunc);
         this._portalsIdstree = param1.addChild(this._portalsIdstreeFunc);
    }

    private void _spellIdFunc(ICustomDataInput param1) {
         this.spellId = param1.readVarUhShort();
         if(this.spellId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellId + ") on element of GameActionFightSpellCastMessage.spellId.");
         }
    }

    private void _spellLevelFunc(ICustomDataInput param1) {
         this.spellLevel = param1.readShort();
         if(this.spellLevel < 1 || this.spellLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.spellLevel + ") on element of GameActionFightSpellCastMessage.spellLevel.");
         }
    }

    private void _portalsIdstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._portalsIdstree.addChild(this._portalsIdsFunc);
            _loc3_++;
         }
    }

    private void _portalsIdsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readShort();
         this.portalsIds.push(_loc2_);
    }

}