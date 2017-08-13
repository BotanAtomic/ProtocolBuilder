package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GuildInfosUpgradeMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5636;
    private boolean _isInitialized = false;
    private int maxTaxCollectorsCount = 0;
    private int taxCollectorsCount = 0;
    private int taxCollectorLifePoints = 0;
    private int taxCollectorDamagesBonuses = 0;
    private int taxCollectorPods = 0;
    private int taxCollectorProspecting = 0;
    private int taxCollectorWisdom = 0;
    private int boostPoints = 0;
    private Vector<uint> spellId;
    private Vector<int> spellLevel;
    private FuncTree _spellIdtree;
    private FuncTree _spellLeveltree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5636;
    }

    public GuildInfosUpgradeMessage initGuildInfosUpgradeMessage(int param1,int  param2,int  param3,int  param4,int  param5,int  param6,int  param7,int  param8,Vector<uint>  param9,Vector<int>  param10) {
         this.maxTaxCollectorsCount = param1;
         this.taxCollectorsCount = param2;
         this.taxCollectorLifePoints = param3;
         this.taxCollectorDamagesBonuses = param4;
         this.taxCollectorPods = param5;
         this.taxCollectorProspecting = param6;
         this.taxCollectorWisdom = param7;
         this.boostPoints = param8;
         this.spellId = param9;
         this.spellLevel = param10;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.maxTaxCollectorsCount = 0;
         this.taxCollectorsCount = 0;
         this.taxCollectorLifePoints = 0;
         this.taxCollectorDamagesBonuses = 0;
         this.taxCollectorPods = 0;
         this.taxCollectorProspecting = 0;
         this.taxCollectorWisdom = 0;
         this.boostPoints = 0;
         this.spellId = new Vector.<uint>();
         this.spellLevel = new Vector.<int>();
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
         this.serializeAs_GuildInfosUpgradeMessage(param1);
    }

    public void serializeAs_GuildInfosUpgradeMessage(ICustomDataOutput param1) {
         if(this.maxTaxCollectorsCount < 0)
         {
            throw new Exception("Forbidden value (" + this.maxTaxCollectorsCount + ") on element maxTaxCollectorsCount.");
         }
         param1.writeByte(this.maxTaxCollectorsCount);
         if(this.taxCollectorsCount < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorsCount + ") on element taxCollectorsCount.");
         }
         param1.writeByte(this.taxCollectorsCount);
         if(this.taxCollectorLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorLifePoints + ") on element taxCollectorLifePoints.");
         }
         param1.writeVarShort(this.taxCollectorLifePoints);
         if(this.taxCollectorDamagesBonuses < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorDamagesBonuses + ") on element taxCollectorDamagesBonuses.");
         }
         param1.writeVarShort(this.taxCollectorDamagesBonuses);
         if(this.taxCollectorPods < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorPods + ") on element taxCollectorPods.");
         }
         param1.writeVarShort(this.taxCollectorPods);
         if(this.taxCollectorProspecting < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorProspecting + ") on element taxCollectorProspecting.");
         }
         param1.writeVarShort(this.taxCollectorProspecting);
         if(this.taxCollectorWisdom < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorWisdom + ") on element taxCollectorWisdom.");
         }
         param1.writeVarShort(this.taxCollectorWisdom);
         if(this.boostPoints < 0)
         {
            throw new Exception("Forbidden value (" + this.boostPoints + ") on element boostPoints.");
         }
         param1.writeVarShort(this.boostPoints);
         param1.writeShort(this.spellId.length);
         int _loc2_ = 0;
         while(_loc2_ < this.spellId.length)
         {
            if(this.spellId[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.spellId[_loc2_] + ") on element 9 (starting at 1) of spellId.");
            }
            param1.writeVarShort(this.spellId[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.spellLevel.length);
         int _loc3_ = 0;
         while(_loc3_ < this.spellLevel.length)
         {
            param1.writeShort(this.spellLevel[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildInfosUpgradeMessage(param1);
    }

    public void deserializeAs_GuildInfosUpgradeMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         * _loc7_ = 0;
         this._maxTaxCollectorsCountFunc(param1);
         this._taxCollectorsCountFunc(param1);
         this._taxCollectorLifePointsFunc(param1);
         this._taxCollectorDamagesBonusesFunc(param1);
         this._taxCollectorPodsFunc(param1);
         this._taxCollectorProspectingFunc(param1);
         this._taxCollectorWisdomFunc(param1);
         this._boostPointsFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readVarUhShort();
            if(_loc6_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of spellId.");
            }
            this.spellId.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readShort();
            this.spellLevel.push(_loc7_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildInfosUpgradeMessage(param1);
    }

    public void deserializeAsyncAs_GuildInfosUpgradeMessage(FuncTree param1) {
         param1.addChild(this._maxTaxCollectorsCountFunc);
         param1.addChild(this._taxCollectorsCountFunc);
         param1.addChild(this._taxCollectorLifePointsFunc);
         param1.addChild(this._taxCollectorDamagesBonusesFunc);
         param1.addChild(this._taxCollectorPodsFunc);
         param1.addChild(this._taxCollectorProspectingFunc);
         param1.addChild(this._taxCollectorWisdomFunc);
         param1.addChild(this._boostPointsFunc);
         this._spellIdtree = param1.addChild(this._spellIdtreeFunc);
         this._spellLeveltree = param1.addChild(this._spellLeveltreeFunc);
    }

    private void _maxTaxCollectorsCountFunc(ICustomDataInput param1) {
         this.maxTaxCollectorsCount = param1.readByte();
         if(this.maxTaxCollectorsCount < 0)
         {
            throw new Exception("Forbidden value (" + this.maxTaxCollectorsCount + ") on element of GuildInfosUpgradeMessage.maxTaxCollectorsCount.");
         }
    }

    private void _taxCollectorsCountFunc(ICustomDataInput param1) {
         this.taxCollectorsCount = param1.readByte();
         if(this.taxCollectorsCount < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorsCount + ") on element of GuildInfosUpgradeMessage.taxCollectorsCount.");
         }
    }

    private void _taxCollectorLifePointsFunc(ICustomDataInput param1) {
         this.taxCollectorLifePoints = param1.readVarUhShort();
         if(this.taxCollectorLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorLifePoints + ") on element of GuildInfosUpgradeMessage.taxCollectorLifePoints.");
         }
    }

    private void _taxCollectorDamagesBonusesFunc(ICustomDataInput param1) {
         this.taxCollectorDamagesBonuses = param1.readVarUhShort();
         if(this.taxCollectorDamagesBonuses < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorDamagesBonuses + ") on element of GuildInfosUpgradeMessage.taxCollectorDamagesBonuses.");
         }
    }

    private void _taxCollectorPodsFunc(ICustomDataInput param1) {
         this.taxCollectorPods = param1.readVarUhShort();
         if(this.taxCollectorPods < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorPods + ") on element of GuildInfosUpgradeMessage.taxCollectorPods.");
         }
    }

    private void _taxCollectorProspectingFunc(ICustomDataInput param1) {
         this.taxCollectorProspecting = param1.readVarUhShort();
         if(this.taxCollectorProspecting < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorProspecting + ") on element of GuildInfosUpgradeMessage.taxCollectorProspecting.");
         }
    }

    private void _taxCollectorWisdomFunc(ICustomDataInput param1) {
         this.taxCollectorWisdom = param1.readVarUhShort();
         if(this.taxCollectorWisdom < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorWisdom + ") on element of GuildInfosUpgradeMessage.taxCollectorWisdom.");
         }
    }

    private void _boostPointsFunc(ICustomDataInput param1) {
         this.boostPoints = param1.readVarUhShort();
         if(this.boostPoints < 0)
         {
            throw new Exception("Forbidden value (" + this.boostPoints + ") on element of GuildInfosUpgradeMessage.boostPoints.");
         }
    }

    private void _spellIdtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._spellIdtree.addChild(this._spellIdFunc);
            _loc3_++;
         }
    }

    private void _spellIdFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of spellId.");
         }
         this.spellId.push(_loc2_);
    }

    private void _spellLeveltreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._spellLeveltree.addChild(this._spellLevelFunc);
            _loc3_++;
         }
    }

    private void _spellLevelFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readShort();
         this.spellLevel.push(_loc2_);
    }

}