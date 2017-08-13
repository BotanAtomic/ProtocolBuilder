package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class MonsterInGroupLightInformations extends Object implements INetworkType {

    private int protocolId = 395;
    private int creatureGenericId = 0;
    private int grade = 0;


    public int getTypeId() {
         return 395;
    }

    public MonsterInGroupLightInformations initMonsterInGroupLightInformations(int param1,int  param2) {
         this.creatureGenericId = param1;
         this.grade = param2;
         return this;
    }

    public void reset() {
         this.creatureGenericId = 0;
         this.grade = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_MonsterInGroupLightInformations(param1);
    }

    public void serializeAs_MonsterInGroupLightInformations(ICustomDataOutput param1) {
         param1.writeInt(this.creatureGenericId);
         if(this.grade < 0)
         {
            throw new Exception("Forbidden value (" + this.grade + ") on element grade.");
         }
         param1.writeByte(this.grade);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MonsterInGroupLightInformations(param1);
    }

    public void deserializeAs_MonsterInGroupLightInformations(ICustomDataInput param1) {
         this._creatureGenericIdFunc(param1);
         this._gradeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MonsterInGroupLightInformations(param1);
    }

    public void deserializeAsyncAs_MonsterInGroupLightInformations(FuncTree param1) {
         param1.addChild(this._creatureGenericIdFunc);
         param1.addChild(this._gradeFunc);
    }

    private void _creatureGenericIdFunc(ICustomDataInput param1) {
         this.creatureGenericId = param1.readInt();
    }

    private void _gradeFunc(ICustomDataInput param1) {
         this.grade = param1.readByte();
         if(this.grade < 0)
         {
            throw new Exception("Forbidden value (" + this.grade + ") on element of MonsterInGroupLightInformations.grade.");
         }
    }

}